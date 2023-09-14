package page.input

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import common.ErrorUi
import common.Header
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.rows
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea
import page.result.ResultPage
import repo.CacheRepoImpl

private const val PLACEHOLDER_PIVOT_INPUT = "Paste your perfetto pivot table data here"

@Composable
fun InputPage(
    inputViewModel: InputViewModel = remember {
        InputViewModel(
            CacheRepoImpl()
        )
    },

    ) {
    Div(
        attrs = {
            classes("container-fluid")

        }
    ) {

        // Header
        Header()

        // Error
        if (inputViewModel.errorMsg.isNotBlank()) {
            ErrorUi(inputViewModel.errorMsg)
        }

        if (inputViewModel.isReadyToShowPivotData) {
            ResultPage(
                inputViewModel.pivotData
            )
        } else {
            InputForm(inputViewModel)
        }

    }
}

@Composable
private fun InputForm(
    viewModel: InputViewModel
) {
    // Main
    Form(
        attrs = {
            style {
                paddingLeft(40.px)
                paddingRight(40.px)
                paddingBottom(40.px)
            }
        }
    ) {
        Div(attrs = {
            classes("row")
        }) {
            Div(attrs = {
                classes("col-lg-6")
            }) {
                PivotDataInputUi(
                    label = "Before",
                    placeholder = PLACEHOLDER_PIVOT_INPUT,
                    data = viewModel.pivotData.before,
                    onInputChanged = { newInput ->
                        viewModel.onBeforeInputChanged(newInput)
                    }
                )
            }

            Div(attrs = {
                classes("col-lg-6")
            }) {
                PivotDataInputUi(
                    label = "After",
                    placeholder = PLACEHOLDER_PIVOT_INPUT,
                    data = viewModel.pivotData.after,
                    onInputChanged = { newInput ->
                        viewModel.onAfterInputChanged(newInput)
                    }
                )
            }
        }

        Div(attrs = {
            classes("row")
        }) {
            Div(attrs = {
                classes("col-lg-12")
            }) {
                Button(
                    attrs = {
                        classes("btn", "btn-outline-primary")
                        style {
                            marginTop(10.px)
                            width(100.percent)
                        }
                        onClick {
                            viewModel.onButtonClicked()
                        }
                        type(ButtonType.Button)
                    }
                ) {
                    Text("🧪 Find Diff")
                }
            }
        }
    }
}

@Composable
fun PivotDataInputUi(
    label: String,
    placeholder: String,
    data: String,
    onInputChanged: (data: String) -> Unit
) {
    Div(
        attrs = {
            classes("form-group")
        }
    ) {

        Label(
            forId = "pivot-data-input",
            attrs = {
                classes("form-label")
            }
        ) {
            B {
                Text("$label :")
            }
        }

        TextArea(
            value = data
        ) {
            id("pivot-data-input")
            classes("form-control")
            placeholder(value = placeholder)
            rows(20)
            onInput { textInput ->
                onInputChanged(textInput.value)
            }
        }
    }
}