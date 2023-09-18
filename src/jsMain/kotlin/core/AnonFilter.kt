package core

import PivotTableRow
import repo.PrefRepo

class AnonFilter(
    prefRepo: PrefRepo
)  : Filter(
    title = "Ignore anonymouse",
    isValuePreserved = true,
    defaultValue = false,
    prefRepo = prefRepo
) {
    override fun apply(list: List<PivotTableRow>): List<PivotTableRow> {
        list.forEach { row ->
            row.name = removeAnon(row.name)
        }
        return list
    }


    private fun removeAnon(name: String): String {
        return name.replace(".<anonymous>", "")
    }


}