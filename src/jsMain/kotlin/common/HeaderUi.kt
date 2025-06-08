package common

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

private const val version = "v25.03.16.1 (16 Mar 2025)"

@Composable
fun Header(
    onTitleClicked: () -> Unit
) {
    Div(attrs = {
        classes("row")
    }) {
        Div(attrs = {
            classes("col-lg-12", "text-center")
            style {
                marginBottom(30.px)
                marginTop(30.px)
            }

        }) {
            H1(
                attrs = {
                    attr("data-bs-toggle", "tooltip")
                    attr("data-bs-placement", "top")
                    attr("title", version)
                    style {
                        cursor("pointer")
                    }
                    onClick {
                        onTitleClicked()
                    }
                }
            ) {
                Text("⚡ diffetto")
            }
        }
    }
}