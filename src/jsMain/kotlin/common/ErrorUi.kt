package common

import androidx.compose.runtime.Composable
import core.ErrorUi
import org.jetbrains.compose.web.dom.Code
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Text

@Composable
fun ErrorUi(errorUi: ErrorUi) {
    Div(attrs = {
        classes("row")
    }) {
        Div(attrs = {
            classes("col-lg-12")
        }) {
            H4(attrs = {
                classes("text-center")
            }) {
                Text("❌ ${errorUi.title}")
            }

            Code {
                Text(errorUi.stacktrace ?: "")
            }
        }
    }
}

@Composable
fun ErrorUi(message: String) {
    Div(attrs = {
        classes("row")
    }) {
        Div(attrs = {
            classes("col-lg-12")
        }) {
            H4(attrs = {
                classes("text-center")
            }) {
                Text("❌ $message")
            }
        }
    }
}