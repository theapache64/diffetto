import kotlinx.browser.window
import org.jetbrains.compose.web.renderComposable
import page.input.InputPage
import page.input.InputViewModel
import page.result.ResultPage

fun main() {
    renderComposable(rootElementId = "root") {
        // redirector
        InputPage()
        // input : path = empty
        // result = result/$local_cache_key
    }
}
