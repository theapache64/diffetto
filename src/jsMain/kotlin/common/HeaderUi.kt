package common

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun Header(
    onTitleClicked: () -> Unit
) {
    Div(attrs = {
        classes("row")
    }) {
        Div(attrs = {
            classes("col-lg-12")
            style {
                marginBottom(30.px)
                marginTop(30.px)
            }
        }) {
            H1(attrs = {
                classes("text-center")
                style {
                    cursor("pointer")
                }
                onClick {
                    onTitleClicked()
                }
            }) { Text("⚡ diffetto") }
        }
    }
}