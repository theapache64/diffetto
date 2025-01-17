package core

import PivotTableRow
import repo.PrefRepo

class LineNoFilter(
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
    override fun apply(name : String): String  {
        return removeLineNoFromRowName(name)
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