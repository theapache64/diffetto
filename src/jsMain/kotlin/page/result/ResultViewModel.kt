package page.result

import Core.diff
import Core.toTable
import DiffTableRow
import PivotData
import PivotTableRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.browser.document
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
    private val prefRepo: PrefRepo,
) {

    companion object {

        private const val KEY_IS_HIDE_FRAMEWORK_CALLS = "is_hide_framework_calls_enabled"
        private const val KEY_IS_IGNORE_LINE_NO = "is_ignore_line_number"
        private const val KEY_IS_IGNORE_LAMBDA = "is_ignore_lambda"

        val systemCallsRegex = listOf(
            "androidx.compose.",
            "android.",
            "com.android.internal.",
            "java.",
            "kotlinx.",
            "kotlin.",
            "sun.",
            "dalvik.",
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

    private lateinit var pivotData: PivotData
    var errorMsg by mutableStateOf("")
        private set

    var uiState by mutableStateOf<ResultUiState>(ResultUiState.Idle)
        private set

    var isHideFrameworkCallsEnabled by mutableStateOf(/*prefRepo.get(KEY_IS_HIDE_FRAMEWORK_CALLS)?.toBoolean() ?:*/ true)
        private set

    var isIgnoreLineNoEnabled by mutableStateOf(prefRepo.get(KEY_IS_IGNORE_LINE_NO)?.toBoolean() ?: false)
        private set

    var isIgnoreLambda by mutableStateOf(prefRepo.get(KEY_IS_IGNORE_LAMBDA)?.toBoolean() ?: false)
        private set

    fun init(pivotData : PivotData) {
        this.pivotData = pivotData
        refreshTable()
    }

    private fun refreshTable() {
        // Update window title first
        document.title = "Diffetto - ${pivotData.resultName}"

        // Then build the result
        val beforeTable = pivotData.before
            .toTable()
            .filters()
        val afterTable = pivotData.after
            .toTable()
            .filters()
        val diffTable = diff(beforeTable, afterTable)

        if (diffTable.isEmpty()) {
            errorMsg = "Something went wrong. Diff table looks empty 🤔"
            return
        }

        updateState(ResultUiState.Success(pivotData.resultName, diffTable, -1))
    }

    private fun List<PivotTableRow>.filters(): List<PivotTableRow> {
        return this.checkSystemCallsFilter()
            .checkLineNoFilter()
            .checkIgnoreLambdaFilter()
    }

    private fun List<PivotTableRow>.checkIgnoreLambdaFilter(): List<PivotTableRow> {
        if (!isIgnoreLambda) return this
        this.forEach { row ->
            row.name = removeLambda(row.name)
        }
        return this
    }

    private fun removeLambda(name: String): String {
        return name.replace(".<anonymous>", "")
    }

    private fun List<PivotTableRow>.checkSystemCallsFilter(): List<PivotTableRow> {
        if (!isHideFrameworkCallsEnabled) return this
        return this.filterNot { row ->
            systemCallsRegex.matches(row.name)
        }
    }

    private fun List<PivotTableRow>.checkLineNoFilter(): List<PivotTableRow> {
        if (!isIgnoreLineNoEnabled) return this
        this.forEach { row ->
            row.name = removeLineNoFromRowName(row.name)
        }
        return this
    }


    private fun removeLineNoFromRowName(name: String): String {
        val result = lineNoRegEx.find(name)
        var newName = name
        if (result != null) {
            newName = result.groupValues.getOrNull(1) ?: name
        }

        if(newName.contains("$1")){
            newName = newName.substring(0, newName.indexOf("\$1"))
        }

        return newName
    }

    fun onHideFrameworkCallsEnabled(newFocusMode: Boolean) {
        isHideFrameworkCallsEnabled = newFocusMode
        prefRepo.set(KEY_IS_HIDE_FRAMEWORK_CALLS, newFocusMode.toString())
        refreshTable()
    }


    private fun updateState(newState: ResultUiState.Success) {
        uiState = newState.copy(createdAt = Date().getMilliseconds())
    }

    fun onIgnoreLineNoChanged(newValue: Boolean) {
        isIgnoreLineNoEnabled = newValue
        prefRepo.set(KEY_IS_IGNORE_LINE_NO, newValue.toString())
        refreshTable()
    }

    fun onTableStructureReady() {
        println("enable bootstrap table powers!")
        js("\$('table').bootstrapTable()")
    }

    fun onIgnoreLambdaChanged(newValue: Boolean) {
        isIgnoreLambda = newValue
        prefRepo.set(KEY_IS_IGNORE_LAMBDA, newValue.toString())
        refreshTable()
    }
}

