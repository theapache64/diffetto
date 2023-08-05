package page.result

import Core.diff
import Core.toTable
import DiffTableRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.url.URL
import page.input.InputViewModel
import repo.PivotRepo

sealed interface ResultUiState {
    data object Idle : ResultUiState
    data class Success(
        val name: String,
        val diffTable: List<DiffTableRow>
    ) : ResultUiState
}

class ResultViewModel(
    val pivotRepo: PivotRepo
) {

    var errorMsg by mutableStateOf("")
        private set

    var uiState by mutableStateOf<ResultUiState>(ResultUiState.Idle)
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
        console.log(pivotData)

        // Update window title first
        document.title = "Diffetto - ${pivotData.resultName}"

        // Then build the result
        val beforeTable = pivotData.before.toTable()
        val afterTable = pivotData.after.toTable()
        val diffTable = diff(beforeTable, afterTable)

        if(diffTable.isEmpty()){
            errorMsg = "Something went wrong. Diff table looks empty 🤔"
            return
        }

        uiState = ResultUiState.Success(pivotData.resultName, diffTable)
    }

}