package core

import repo.PrefRepo

class IgnoreOwnerThreadId(
    prefRepo: PrefRepo
) : Filter(
    title = "Ignore owner thread id",
    isValuePreserved = true,
    defaultValue = false,
    prefRepo = prefRepo
) {
    companion object{
        private val regex = " \\(owner tid: \\d+\\)".toRegex()
    }
    override fun apply(name: String): String {
        return removeOwnerThreadId(name)
    }

    private fun removeOwnerThreadId(name: String): String {
        return name.replace(regex, "")
    }
}