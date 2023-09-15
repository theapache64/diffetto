package page.result

import PivotData
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import common.ErrorUi
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Table
import org.jetbrains.compose.web.dom.Tbody
import org.jetbrains.compose.web.dom.Td
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Th
import org.jetbrains.compose.web.dom.Thead
import org.jetbrains.compose.web.dom.Tr
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
    if (viewModel.errorMsg.isNotBlank()) {
        ErrorUi(viewModel.errorMsg)
    }

    when (val uiState = viewModel.uiState) {
        ResultUiState.Idle -> {
            // nothing
            Text("Loading...")
        }

        is ResultUiState.Success -> {
            H2 {
                Text(uiState.name)
            }

            Div(
                attrs = {
                    classes("d-flex", "justify-content-end")
                }
            ) {
                Div(
                    attrs = {
                        classes("form-check")
                    }
                ) {
                    Input(
                        type = InputType.Checkbox,
                        attrs = {
                            id("cbHideFrameworkCalls")
                            classes("form-check-input")
                            checked(viewModel.isHideFrameworkCallsEnabled)
                            onInput {
                                viewModel.onHideFrameworkCallsEnabled(it.value)
                            }
                        }
                    )
                    Label(
                        forId = "cbHideFrameworkCalls"
                    ) {
                        Text("Hide framework calls")
                    }
                }

                Div(
                    attrs = {
                        classes("form-check", "ms-2")
                    }
                ) {
                    Input(
                        type = InputType.Checkbox,
                        attrs = {
                            id("cbIgnoreLineNo")
                            classes("form-check-input")
                            checked(viewModel.isIgnoreLineNoEnabled)
                            onInput {
                                viewModel.onIgnoreLineNoChanged(it.value)
                            }
                        }
                    )
                    Label(
                        forId = "cbIgnoreLineNo"
                    ) {
                        Text("Ignore line number")
                    }
                }

                Div(
                    attrs = {
                        classes("form-check", "ms-2")
                    }
                ) {
                    Input(
                        type = InputType.Checkbox,
                        attrs = {
                            id("cbIgnoreLambda")
                            classes("form-check-input")
                            checked(viewModel.isIgnoreLambda)
                            onInput {
                                viewModel.onIgnoreLambdaChanged(it.value)
                            }
                        }
                    )
                    Label(
                        forId = "cbIgnoreLambda"
                    ) {
                        Text("Ignore lambda")
                    }
                }

                // <a href="#link" class="btn btn-info" role="button">Link Button</a>
                A(
                    href = "data:application/octet-stream,${viewModel.downloadData}",
                    attrs = {
                        attr("download", "diffetto_${uiState.name.asFileName()}.csv")
                        classes("btn", "btn-outline-success", "btn-sm", "ms-2")
                        attr("role", "button")
                    },
                ) {
                    Text("▽ DOWNLOAD as CSV")
                }

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

                        }
                    ) {
                        Thead {
                            Tr {
                                listOf(
                                    "Name", "Before (ms)", "After (ms)", "Diff (ms)", "Count diff"
                                ).forEach { columnName ->
                                    key(columnName) {
                                        Th(
                                            attrs = {
                                                attr("data-field", columnName)
                                                attr("data-sortable", "true")
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
                                        Td { Text(row.countDiff) }
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
    return this.replace("\\W+".toRegex(),"_")
}
