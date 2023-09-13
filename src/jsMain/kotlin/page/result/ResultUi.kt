package page.result

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import common.ErrorUi
import common.Header
import org.jetbrains.compose.web.attributes.InputType
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
import repo.PivotRepoImpl
import repo.PrefRepoImpl

@Composable
fun ResultPage(
    viewModel: ResultViewModel = remember {
        ResultViewModel(
            PivotRepoImpl(),
            PrefRepoImpl()
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
                Text("Loading...")
            }

            is ResultUiState.Success -> {
                H2 {
                    Text(uiState.name)
                }

                /**
                 * <div class="form-check">
                 *   <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                 *   <label class="form-check-label" for="flexCheckDefault">
                 *     Default checkbox
                 *   </label>
                 * </div>
                 */

                Div(
                    attrs = {
                        classes("d-flex","justify-content-end")
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
                        ){
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
                        ){
                            Text("Ignore line number")
                        }
                    }
                }

                key(uiState.createdAt.toString()){
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
                            }
                        }
                    }
                }
            }
        }

    }
}