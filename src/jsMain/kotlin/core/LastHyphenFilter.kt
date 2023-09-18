package core

import PivotTableRow
import repo.PrefRepo

class LastHyphenFilter(
    prefRepo: PrefRepo
) : Filter(
    title = "Ignore last hyphen",
    isValuePreserved = true,
    defaultValue = false,
    prefRepo = prefRepo
) {
    override fun apply(list: List<PivotTableRow>): List<PivotTableRow> {
        return list.onEach {
            it.name = removeLastHyphen(it.name)
        }
    }

    private fun removeLastHyphen(name: String): String {
        val hyphenIndex = name.lastIndexOf('-')
        if (hyphenIndex == -1) return name
        return name.substring(0, hyphenIndex)
    }
}