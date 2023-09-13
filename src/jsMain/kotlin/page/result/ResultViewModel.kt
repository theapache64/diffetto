package page.result

import Core.diff
import Core.toTable
import DiffTableRow
import PivotTableRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.url.URL
import page.input.InputViewModel
import repo.PivotRepo
import kotlin.js.Date

sealed interface ResultUiState {
    data object Idle : ResultUiState
    data class Success(
        val name: String, val diffTable: List<DiffTableRow>, val createdAt: Int // Workaround to trigger recomposition
    ) : ResultUiState
}

class ResultViewModel(
    private val pivotRepo: PivotRepo
) {

    companion object{
        val systemCallsRegex = "^(androidx.compose.|Choreographer#|HWUI:|Compose:|Recomposer:|AndroidOwner:|draw|animation|layout|traversal|measure|Record View#draw\\(\\)).*".toRegex()
    }

    var errorMsg by mutableStateOf("")
        private set

    var uiState by mutableStateOf<ResultUiState>(ResultUiState.Idle)
        private set

    // TODO: Provide a checkbox
    var isHideSystemCalls by mutableStateOf(true)
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
        val beforeTable = pivotData.before.toTable().checkSystemCallsFilter()
        val afterTable = pivotData.after.toTable().checkSystemCallsFilter()
        val diffTable = diff(beforeTable, afterTable)

        if (diffTable.isEmpty()) {
            errorMsg = "Something went wrong. Diff table looks empty 🤔"
            return
        }

        updateState(ResultUiState.Success(pivotData.resultName, diffTable, -1))
    }

    private fun List<PivotTableRow>.checkSystemCallsFilter(): List<PivotTableRow> {
        if (!isHideSystemCalls) return this
        return this.filterNot { row ->
            systemCallsRegex.matches(row.name)
        }
    }

    fun onFocusModeChanged(newFocusMode: Boolean) {
        isHideSystemCalls = newFocusMode
        init()
    }


    private fun updateState(newState: ResultUiState.Success) {
        uiState = newState.copy(createdAt = Date().getMilliseconds())
    }
}

