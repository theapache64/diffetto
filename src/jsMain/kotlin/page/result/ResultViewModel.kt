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
import repo.PrefRepo
import kotlin.js.Date

sealed interface ResultUiState {
    data object Idle : ResultUiState
    data class Success(
        val name: String, val diffTable: List<DiffTableRow>, val createdAt: Int // Workaround to trigger recomposition
    ) : ResultUiState
}

external interface BootstrapTable {
    fun bootstrapTable()
    // etc
}


class ResultViewModel(
    private val pivotRepo: PivotRepo,
    private val prefRepo: PrefRepo,
) {

    companion object {

        private const val KEY_IS_HIDE_FRAMEWORK_CALLS = "is_hide_framework_calls_enabled"
        private const val KEY_IS_IGNORE_LINE_NO = "is_ignore_line_number"

        val systemCallsRegex = listOf(
            "androidx.compose.",
            "Choreographer#",
            "HWUI:",
            "Compose:",
            "Recomposer:",
            "AndroidOwner:",
            "draw",
            "animation",
            "layout",
            "traversal",
            "measure",
            "Record View#draw\\(\\)"
        ).joinToString(separator = "|", prefix = "^(", postfix = ").*").toRegex()

        val lineNoRegEx = "^(?<title>.+) (?<lineNo>\\(.+:\\d+\\))\$".toRegex()
    }

    var errorMsg by mutableStateOf("")
        private set

    var uiState by mutableStateOf<ResultUiState>(ResultUiState.Idle)
        private set

    var isHideFrameworkCallsEnabled by mutableStateOf(prefRepo.get(KEY_IS_HIDE_FRAMEWORK_CALLS)?.toBoolean() ?: true)
        private set

    var isIgnoreLineNoEnabled by mutableStateOf(prefRepo.get(KEY_IS_IGNORE_LINE_NO)?.toBoolean() ?: false)
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
        val beforeTable = pivotData.before.toTable().checkSystemCallsFilter().checkLineNoFilter()
        val afterTable = pivotData.after.toTable().checkSystemCallsFilter().checkLineNoFilter()
        val diffTable = diff(beforeTable, afterTable)

        if (diffTable.isEmpty()) {
            errorMsg = "Something went wrong. Diff table looks empty 🤔"
            return
        }

        updateState(ResultUiState.Success(pivotData.resultName, diffTable, -1))
    }

    private fun List<PivotTableRow>.checkSystemCallsFilter(): List<PivotTableRow> {
        if (!isHideFrameworkCallsEnabled) return this
        return this.filterNot { row ->
            systemCallsRegex.matches(row.name)
        }
    }

    private fun List<PivotTableRow>.checkLineNoFilter(): List<PivotTableRow> {
        println("line filter")
        if (!isIgnoreLineNoEnabled) return this
        this.forEach { row ->
            row.name = removeLineNoFromRowName(row.name)
        }
        return this
    }


    private fun removeLineNoFromRowName(name: String): String {
        val result = lineNoRegEx.find(name)
        if (result != null) {
            return result.groupValues.getOrNull(1) ?: name
        }
        return name
    }

    fun onHideFrameworkCallsEnabled(newFocusMode: Boolean) {
        isHideFrameworkCallsEnabled = newFocusMode
        prefRepo.set(KEY_IS_HIDE_FRAMEWORK_CALLS, newFocusMode.toString())
        window.location.reload()
    }


    private fun updateState(newState: ResultUiState.Success) {
        uiState = newState.copy(createdAt = Date().getMilliseconds())
    }

    fun onIgnoreLineNoChanged(newValue: Boolean) {
        isIgnoreLineNoEnabled = newValue
        prefRepo.set(KEY_IS_IGNORE_LINE_NO, newValue.toString())
        window.location.reload()
    }
}

