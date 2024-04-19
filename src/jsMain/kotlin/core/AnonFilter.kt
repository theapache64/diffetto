package core

import repo.PrefRepo

class AnonFilter(
    prefRepo: PrefRepo
) : Filter(
    title = "Ignore anonymous",
    isValuePreserved = true,
    defaultValue = false,
    prefRepo = prefRepo
) {
    override fun apply(name: String): String {
        return removeAnon(name)
    }

    private fun removeAnon(name: String): String {
        return name.replace(".<anonymous>", "")
    }


}