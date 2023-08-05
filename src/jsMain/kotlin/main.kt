import kotlinx.browser.window
import org.jetbrains.compose.web.renderComposable
import page.input.InputPage
import page.result.ResultPage
import repo.PivotRepo

fun main() {
    renderComposable(rootElementId = "root") {
        // redirector
        val path = window.location.search
        if (path.contains(PivotRepo.KEY_LOCAL_CACHE_KEY)) {
            ResultPage()
        } else {
            InputPage()
        }
        // input : path = empty
        // result = result/$local_cache_key
    }
}
