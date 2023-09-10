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

    var errorMsg by mutableStateOf("")
        private set

    var uiState by mutableStateOf<ResultUiState>(ResultUiState.Idle)
        private set

    // TODO: Provide a checkbox
    var isFocusModeEnabled by mutableStateOf(true)
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
        val beforeTable = pivotData.before.toTable().filterForFocusMode()
        val afterTable = pivotData.after.toTable().filterForFocusMode()
        val diffTable = diff(beforeTable, afterTable)

        if (diffTable.isEmpty()) {
            errorMsg = "Something went wrong. Diff table looks empty 🤔"
            return
        }

        updateState(ResultUiState.Success(pivotData.resultName, diffTable, -1))
    }


    private fun List<PivotTableRow>.filterForFocusMode(): List<PivotTableRow> {
        if (!isFocusModeEnabled) return this
        return this.filterNot {
            it.name.startsWith("androidx.compose.") ||
                    it.name.startsWith("Choreographer#") ||
                    it.name.startsWith("HWUI:") ||
                    it.name.startsWith("Compose:") ||
                    it.name.startsWith("Recomposer:") ||
                    it.name.startsWith("AndroidOwner:") ||
                    it.name == "draw" ||
                    it.name == "animation" ||
                    it.name == "layout" ||
                    it.name == "traversal" ||
                    it.name == "measure" ||
                    it.name == "Record View#draw()"
        }
    }

    fun onFocusModeChanged(newFocusMode: Boolean) {
        isFocusModeEnabled = newFocusMode
        init()
    }


    private fun updateState(newState: ResultUiState.Success) {
        uiState = newState.copy(createdAt = Date().getMilliseconds())
    }
}

