import org.jetbrains.compose.web.renderComposable
import page.input.App

fun main() {
    renderComposable(rootElementId = "root") {
        // redirector
        App()
        // input : path = empty
        // result = result/$local_cache_key
    }
}
