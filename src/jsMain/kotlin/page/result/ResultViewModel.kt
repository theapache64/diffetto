package page.result

import Core.diff
import Core.toTable
import DiffTableRow
import PivotData
import PivotTableRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import core.Filter
import core.FrameworkCallsFilter
import kotlinx.browser.document
import repo.PrefRepo
import kotlin.js.Date
import kotlin.time.measureTime

sealed interface ResultUiState {
    data object Idle : ResultUiState
    data class Success(
        val name: String, val diffTable: List<DiffTableRow>, val createdAt: Int // Workaround to trigger recomposition
    ) : ResultUiState
}

class ResultViewModel(
    private val prefRepo: PrefRepo,
) {

    val filters = listOf<Filter>(
        FrameworkCallsFilter(prefRepo)
    )

    companion object {
        private const val KEY_IS_IGNORE_LINE_NO = "is_ignore_line_number"
        private const val KEY_IS_IGNORE_ANON = "is_ignore_anon"

        val lineNoRegEx = "^(?<title>.+) (?<lineNo>\\(.+:\\d+\\))\$".toRegex()
    }

    private lateinit var pivotData: PivotData
    var errorMsg by mutableStateOf("")
        private set

    var uiState by mutableStateOf<ResultUiState>(ResultUiState.Idle)
        private set

    var isIgnoreLineNoEnabled by mutableStateOf(prefRepo.get(KEY_IS_IGNORE_LINE_NO)?.toBoolean() ?: false)
        private set

    var isIgnoreAnon by mutableStateOf(prefRepo.get(KEY_IS_IGNORE_ANON)?.toBoolean() ?: false)
        private set

    var downloadData by mutableStateOf("")
        private set

    fun init(pivotData: PivotData) {
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
        val diffTable = diff(beforeTable, afterTable).sortedByDescending { it.diff }

        if (diffTable.isEmpty()) {
            errorMsg = "Something went wrong. Diff table looks empty 🤔"
            return
        }

        updateState(ResultUiState.Success(pivotData.resultName, diffTable, -1))

        measureTime {
            val csvBuilder = StringBuilder()
            // header
            csvBuilder.append("Name,Before (ms),After (ms),Diff (ms),Count diff\n")
            for (row in diffTable) {
                csvBuilder.append("${row.name},${row.beforeTimeInMs},${row.afterTimeInMs},${row.diff},${row.countDiff}%0A")
            }

            downloadData = csvBuilder.toString()
        }.let {
            println("CSV prep took ${it.inWholeMilliseconds} ms")
        }
    }

    private fun List<PivotTableRow>.filters(): List<PivotTableRow> {
        var list = this
        for (filter in filters) {
            if (filter.isEnabled) {
                list = filter.apply(list)
            }
        }
        return list.checkLineNoFilter()
            .checkIgnoreAnonFilter()
    }

    private fun List<PivotTableRow>.checkIgnoreAnonFilter(): List<PivotTableRow> {
        if (!isIgnoreAnon) return this
        this.forEach { row ->
            row.name = removeAnon(row.name)
        }
        return this
    }

    private fun removeAnon(name: String): String {
        return name.replace(".<anonymous>", "")
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

        if (newName.contains("$1")) {
            newName = newName.substring(0, newName.indexOf("\$1"))
        }

        return newName
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

    fun onIgnoreAnonChanged(newValue: Boolean) {
        isIgnoreAnon = newValue
        prefRepo.set(KEY_IS_IGNORE_ANON, newValue.toString())
        refreshTable()
    }

    fun onFilterChanged(filter: Filter, newValue: Boolean) {
        filter.setEnabled(newValue)
        refreshTable()
    }
}

