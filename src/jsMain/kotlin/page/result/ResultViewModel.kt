package page.result

import Core.diff
import Core.generateFullHtml
import Core.toTable
import DiffTableRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.browser.window
import org.w3c.dom.url.URL
import page.input.InputViewModel
import repo.PivotRepo

class ResultViewModel(
    val pivotRepo: PivotRepo
) {

    var errorMsg by mutableStateOf("")
        private set

    var diffTable by mutableStateOf(emptyList<DiffTableRow>())
        private set

    init {
        init()
    }

    private fun init() {
        val localCacheKey = URL(window.location.href).searchParams.get(InputViewModel.KEY_LOCAL_CACHE_KEY)
        if (localCacheKey == null) {
            errorMsg = "${InputViewModel.KEY_LOCAL_CACHE_KEY} missing from URL"
            return
        }

        val pivotData = pivotRepo.getPivotData(localCacheKey)
        if (pivotData == null) {
            errorMsg = "Invalid ${InputViewModel.KEY_LOCAL_CACHE_KEY} '$localCacheKey'"
            return
        }

        with(pivotData) {
            val beforeTable = before.toTable()
            val afterTable = after.toTable()
            diffTable = diff(beforeTable, afterTable)
        }
    }

}