package page.result

import PivotData
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import common.ErrorUi
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Table
import org.jetbrains.compose.web.dom.Tbody
import org.jetbrains.compose.web.dom.Td
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Th
import org.jetbrains.compose.web.dom.Thead
import org.jetbrains.compose.web.dom.Tr
import page.input.onTitleClicked
import repo.PrefRepoImpl

@Composable
fun ResultUi(
    pivotData: PivotData,
    viewModel: ResultViewModel = remember {
        ResultViewModel(
            PrefRepoImpl()
        )
    },
) {
    LaunchedEffect(viewModel, pivotData) {
        viewModel.init(pivotData)
    }

    // Error
    viewModel.errorUi?.let {
        ErrorUi(it)
    } ?: ResultUi(viewModel)
}

@Composable
private fun ResultUi(viewModel: ResultViewModel) {
    when (val uiState = viewModel.uiState) {
        ResultUiState.Idle -> {
            // nothing
            Text("Loading... (this may take a while)")
        }

        is ResultUiState.Success -> {
            H2(
                attrs = {
                    style {
                        cursor("pointer")
                    }
                    onClick {
                        onTitleClicked()
                    }
                }
            ) {
                Text("← ${uiState.name}")
            }

            Div(
                attrs = {
                    classes("d-flex", "justify-content-end")
                }
            ) {
                viewModel.filters.forEach { filter ->
                    key(filter.title) {
                        Div(
                            attrs = {
                                classes("form-check", "ms-2")
                            }
                        ) {
                            Input(
                                type = InputType.Checkbox,
                                attrs = {
                                    id(filter.title)
                                    classes("form-check-input")
                                    checked(filter.isEnabled)
                                    onInput {
                                        viewModel.onFilterChanged(filter, it.value)
                                    }
                                }
                            )
                            Label(
                                forId = filter.title
                            ) {
                                Text(filter.title)
                            }
                        }
                    }
                }

                A(
                    href = "data:application/octet-stream,${viewModel.exportData}",
                    attrs = {
                        attr("download", "diffetto_${uiState.name.asFileName()}.csv")
                        classes("btn", "btn-outline-success", "btn-sm", "ms-2")
                        attr("role", "button")
                    },
                ) {
                    Text("🚚 Export")
                }
            }

            Div(
                attrs = {
                    classes("d-flex", "justify-content-end", "mt-2", "mb-2")
                }
            ) {
                // Search Input
                Input(
                    type = InputType.Text,
                    attrs = {
                        id("searchInput")
                        classes("form-control")
                        attr("placeholder", "🔍 Search")
                        style {
                            property("width", "300px")
                        }
                        onInput {
                            viewModel.onSearchTextUpdated(it.value)
                        }
                    }
                )
            }

            key(uiState.createdAt.toString()) {
                Div(
                    attrs = {
                        classes("table-responsive")
                    }
                ) {
                    Table(
                        attrs = {
                            id("result-table")
                            classes("table", "table-bordered")
                            attr("data-toggle", "table")
                            attr("data-search", "true")
                            attr("data-sort-name", "Diff (ms)")
                            attr("data-sort-order", "desc")
                            attr("data-pagination", "true")
                            attr("data-page-size", "300")
                            attr("data-pagination-v-align", "both")
                            attr("data-search-highlight", "true")
                            attr("data-search-selector","#searchInput")
                            attr("data-search-text",viewModel.searchText)
                        }
                    ) {
                        Thead {
                            Tr {
                                listOf(
                                    "Name", "Before (ms)", "After (ms)", "Diff (ms)", "Before count","After count", "Count diff"
                                ).forEach { columnName ->
                                    key(columnName) {
                                        Th(
                                            attrs = {
                                                attr("data-field", columnName)
                                                attr("data-sortable", "true")
                                                attr("data-searchable", (columnName == "Name").toString())
                                            }
                                        ) {
                                            Text(columnName)
                                        }
                                    }
                                }
                            }
                        }
                        Tbody(
                            attrs = {
                                id("tbResult")
                            }
                        ) {

                            uiState.diffTable.forEach { row ->
                                key(row.name) {
                                    Tr {
                                        Td {
                                            Text(row.name)
                                        }
                                        Td { Text(row.beforeTimeInMs) }
                                        Td { Text(row.afterTimeInMs) }
                                        Td {
                                            Text("${row.diff ?: 0}")
                                        }
                                        Td { Text(row.beforeCount.toString()) }
                                        Td { Text(row.afterCount.toString()) }
                                        Td(
                                            attrs = {
                                                title(
                                                    """
                                                  before: ${row.beforeCount}
                                                  after: ${row.afterCount}
                                              """.trimIndent()
                                                )
                                            },
                                        ) { Text(row.countDiff) }
                                    }
                                }
                            }

                            SideEffect {
                                viewModel.onTableStructureReady()
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun String.asFileName(): String {
    return this.replace("\\W+".toRegex(), "_")
}
