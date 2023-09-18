package core

import PivotTableRow
import page.result.ResultViewModel
import repo.PrefRepo

class IgnoreLineFilter(
    prefRepo: PrefRepo
)  : Filter(
    title = "Ignore line number",
    isValuePreserved = true,
    defaultValue = false,
    prefRepo = prefRepo
){
    companion object{
        private val lineNoRegEx = "^(?<title>.+) (?<lineNo>\\(.+:\\d+\\))\$".toRegex()
    }
    override fun apply(list: List<PivotTableRow>): List<PivotTableRow> {
        return list.onEach { row ->
            row.name = removeLineNoFromRowName(row.name)
        }
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
}