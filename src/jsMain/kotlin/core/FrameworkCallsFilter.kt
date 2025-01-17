package core

import PivotTableRow
import repo.PrefRepo

class FrameworkCallsFilter(prefRepo: PrefRepo) : Filter(
    title = "Hide framework calls",
    isValuePreserved = false,
    defaultValue = true,
    prefRepo = prefRepo
) {
    companion object {
        private val systemCallsRegex = listOf(
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

        private val specialSystemCallsRegex = listOf(
            "android.app.ActivityThread.handleBindApplication",
            "android.app.ActivityThread.installContentProviders",
        ).joinToString(separator = "|", prefix = "^(", postfix = ").*").toRegex()
    }

    override fun apply(name : String): String?  {
        return if(systemCallsRegex.matches(name) && !specialSystemCallsRegex.matches(name)){
            null
        }else{
            name
        }
    }
}