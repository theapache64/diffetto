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
import kotlin.js.Date

sealed interface ResultUiState {
    data object Idle : ResultUiState
    data class Success(
        val name: String,
        val diffTable: List<DiffTableRow>,
        val createdAt: Int // Workaround to trigger recomposition
    ) : ResultUiState
}

class ResultViewModel(
    private val pivotRepo: PivotRepo
) {

    var errorMsg by mutableStateOf("")
        private set

    var searchKeyword by mutableStateOf("")
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
        val beforeTable = pivotData.before.toTable().find {
            it.name.contains("CompositionLocal.kt:225")
        }!!.let {
            listOf(it)
        }
        val afterTable = pivotData.after.toTable().find {
            it.name.contains("CompositionLocal.kt:225")
        }!!.let {
            listOf(it)
        }
        val diffTable = diff(beforeTable, afterTable).applySearch(searchKeyword)

        if (diffTable.isEmpty()) {
            errorMsg = "Something went wrong. Diff table looks empty 🤔"
            return
        }

        updateState(ResultUiState.Success(pivotData.resultName, diffTable, -1))
    }

    fun onSearchKeywordChanged(value: String) {
        console.log("Search: '$value'")
        this.searchKeyword = value.trim()
        val successState = uiState as? ResultUiState.Success ?: return
        val newState = successState.copy(diffTable = successState.diffTable.applySearch(searchKeyword))
        updateState(newState)
    }

    private fun updateState(newState: ResultUiState.Success) {
        uiState = newState.copy(createdAt = Date().getMilliseconds())
    }
}

private fun List<DiffTableRow>.applySearch(keyword: String): List<DiffTableRow> {
    return if (keyword.isBlank()) {
        this.onEach { row ->
            row.isVisible = true
        }
    } else {
        this.onEach { row ->
            row.isVisible = row.name.contains(keyword, ignoreCase = true).also {
                console.log("${row.name} -> $it")
            }
        }
    }
}

