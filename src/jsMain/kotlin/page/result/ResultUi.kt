package page.result

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import common.ErrorUi
import common.Header
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Table
import org.jetbrains.compose.web.dom.Tbody
import org.jetbrains.compose.web.dom.Td
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Th
import org.jetbrains.compose.web.dom.Thead
import org.jetbrains.compose.web.dom.Tr
import repo.PivotRepoImpl

@Composable
fun ResultPage(
    viewModel: ResultViewModel = remember {
        ResultViewModel(
            PivotRepoImpl()
        )
    }
) {

    Div(
        attrs = {
            classes("container-fluid")
        }
    ) {
        // Header
        Header()

        // Error
        if (viewModel.errorMsg.isNotBlank()) {
            ErrorUi(viewModel.errorMsg)
        }

        when (val uiState = viewModel.uiState) {
            ResultUiState.Idle -> {
                // nothing
            }

            is ResultUiState.Success -> {
                H2 {
                    Text(uiState.name)
                }
                P {
                    Text("Type something in the input field to search the table :")
                }
                Input(
                    type = InputType.Text,
                ) {
                    classes("form-control")
                    id("search-input")
                    placeholder("Search...")
                }
                Br()
                Div(
                    attrs = {
                        classes("table-responsive")
                    }
                ) {
                    Table(
                        attrs = {
                            classes("table", "table-bordered")
                            attr("data-toggle", "table")
                        }
                    ) {
                        Thead {
                            Tr {
                                listOf(
                                    "Name", "Before", "After", "Diff", "Count diff"
                                ).forEach { columnName ->
                                    Th(
                                        attrs = {
                                            attr("data-sortable", "true")
                                        }
                                    ) {
                                        Text(columnName)
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
                                Tr {
                                    Td { Text(row.name) }
                                    Td { Text(row.beforeTimestamp) }
                                    Td { Text(row.afterTimestamp) }
                                    Td { Text(row.diff) }
                                    Td { Text(row.countDiff) }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}