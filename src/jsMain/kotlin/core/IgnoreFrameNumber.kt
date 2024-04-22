package core

import repo.PrefRepo

class IgnoreFrameNumber(
    prefRepo: PrefRepo
) : Filter(
    title = "Ignore frame number",
    isValuePreserved = true,
    defaultValue = false,
    prefRepo = prefRepo
) {
    companion object {
        private val regex = "^Choreographer#doFrame \\d+$".toRegex()
    }

    override fun apply(name: String): String {
        return removeOwnerThreadId(name)
    }

    private fun removeOwnerThreadId(name: String): String {
        return if (name.matches(regex)) {
            "Choreographer#doFrame"
        } else {
            name
        }
    }
}