package page.result

import Core.diff
import Core.toTable
import DiffTableRow
import PivotData
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import core.AnonFilter
import core.ErrorUi
import core.Filter
import core.FrameworkCallsFilter
import core.IgnoreOwnerThreadId
import core.LastHyphenFilter
import core.LineNoFilter
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
    prefRepo: PrefRepo,
) {

    val filters = listOf(
        FrameworkCallsFilter(prefRepo),
        LineNoFilter(prefRepo),
        AnonFilter(prefRepo),
        LastHyphenFilter(prefRepo),
        IgnoreOwnerThreadId(prefRepo)
    )

    private lateinit var pivotData: PivotData
    var errorUi by mutableStateOf<ErrorUi?>(null)
        private set

    var uiState by mutableStateOf<ResultUiState>(ResultUiState.Idle)
        private set

    var exportData by mutableStateOf("")
        private set

    var searchText by mutableStateOf("")
        private set


    fun init(pivotData: PivotData) {
        this.pivotData = pivotData
        refreshTable()
    }

    private fun refreshTable() {
        measureTime {
            try {
                // Update window title first
                document.title = "Diffetto - ${pivotData.resultName}"

                // Then build the result
                val beforeTable = pivotData.before.toTable(filters)
                val afterTable = pivotData.after.toTable(filters)
                console.log(beforeTable, afterTable)
                println("QuickTag: ResultViewModel:refreshTable: ${beforeTable.size} ${afterTable.size}")
                val diffTable = diff(beforeTable, afterTable).sortedByDescending { it.diff }

                if (diffTable.isEmpty()) {
                    errorUi = ErrorUi(
                        title = "Something went wrong. Diff table looks empty 🤔",
                    )
                    return
                }

                updateState(ResultUiState.Success(pivotData.resultName, diffTable, -1))

                measureTime {
                    val csvBuilder = StringBuilder()
                    // header
                    csvBuilder.append("Name,Before (ms),After (ms),Diff (ms),Before count,After count,Count diff%0A")
                    for (row in diffTable) {
                        csvBuilder.append("${row.name},${row.beforeTimeInMs},${row.afterTimeInMs},${row.diff},${row.beforeCount},${row.afterCount},${row.countDiff}%0A")
                    }

                    exportData = csvBuilder.toString()
                }.let {
                    println("CSV prep took ${it.inWholeMilliseconds} ms")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                errorUi = ErrorUi(
                    title = "Corrupted Data 😢",
                    stacktrace = e.stackTraceToString()
                )
            }
        }.let {
            println("Diff calculation took ${it.inWholeMilliseconds} ms")
        }
    }

    private fun updateState(newState: ResultUiState.Success) {
        uiState = newState.copy(createdAt = Date().getMilliseconds())
    }

    fun onTableStructureReady() {
        println("enable bootstrap table powers!")
        js("\$('table').bootstrapTable()")
    }

    fun onFilterChanged(filter: Filter, newValue: Boolean) {
        filter.setEnabled(newValue)
        refreshTable()
    }

    fun onSearchTextUpdated(keyword: String) {
        this.searchText = keyword
    }
}

