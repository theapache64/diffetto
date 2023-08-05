package page.input

import Core
import PivotData
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.browser.window
import repo.CacheRepo
import repo.PivotRepo

class InputViewModel(
    val pivotRepo: PivotRepo,
    val cacheRepo: CacheRepo
) {

    companion object {
        private const val KEY_BEFORE_CACHE = "before_cache"
        private const val KEY_AFTER_CACHE = "after_cache"

        private const val DEFAULT_BEFORE_INPUT =
            """androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:225)	1s 781ms 483us 177ns	null	174	arrow_right
traversal	1s 305ms 816us 439ns	null	2	arrow_right
draw	1s 300ms 54us 592ns	null	2	arrow_right
Record View#draw()	1s 296ms 220us 361ns	null	2	arrow_right
HWUI:com.android.internal.policy.DecorView	1s 296ms 177us 975ns	null	2	arrow_right
HWUI:android.widget.LinearLayout	1s 296ms 72us 437ns	null	2	arrow_right
HWUI:android.widget.FrameLayout	1s 296ms 49us 668ns	null	2	arrow_right
HWUI:androidx.appcompat.widget.FitWindowsLinearLayout	1s 296ms 28us 53ns	null	2	arrow_right
HWUI:androidx.appcompat.widget.ContentFrameLayout	1s 296ms 5us 53ns	null	2	arrow_right
HWUI:androidx.compose.ui.platform.ComposeView	1s 295ms 982us 899ns	null	2	arrow_right"""

        private const val DEFAULT_AFTER_INPUT =
            """androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:225)	2s 263ms 557us 531ns	null	179	arrow_right
Choreographer#doFrame 11926598	1s 480ms 319us 148ns	null	1	arrow_right
traversal	1s 479ms 350us 302ns	null	2	arrow_right
draw	1s 460ms 424us 300ns	null	2	arrow_right
Record View#draw()	1s 455ms 353us 453ns	null	2	arrow_right
HWUI:com.android.internal.policy.DecorView	1s 455ms 287us 761ns	null	2	arrow_right
HWUI:android.widget.LinearLayout	1s 455ms 85us 607ns	null	2	arrow_right
HWUI:android.widget.FrameLayout	1s 454ms 987us 300ns	null	2	arrow_right
HWUI:androidx.appcompat.widget.FitWindowsLinearLayout	1s 454ms 960us 147ns	null	2	arrow_right
HWUI:androidx.appcompat.widget.ContentFrameLayout	1s 454ms 936us 375ns	null	2	arrow_right"""
    }


    var errorMsg by mutableStateOf("")
        private set

    var pivotData by mutableStateOf(
        PivotData(
            cacheRepo.getString(KEY_BEFORE_CACHE) ?: DEFAULT_BEFORE_INPUT,
            cacheRepo.getString(KEY_AFTER_CACHE) ?: DEFAULT_AFTER_INPUT,
        )
    )
        private set


    fun onBeforeInputChanged(newInput: String) {
        pivotData = pivotData.copy(before = newInput)
        cacheRepo.saveString(KEY_BEFORE_CACHE, newInput)
    }

    fun onAfterInputChanged(newInput: String) {
        pivotData = pivotData.copy(after = newInput)
        console.log(newInput)
        cacheRepo.saveString(KEY_AFTER_CACHE, newInput)
    }

    fun onButtonClicked() {
        val errorMsg = pivotData.validate()
        if (errorMsg != null) {
            // update error message state
            this.errorMsg = errorMsg
            return
        }


        val localCacheKey = pivotRepo.savePivotData(pivotData)
        window.alert(localCacheKey)
    }


    private fun PivotData.validate(): String? {
        val errorBuilder = StringBuilder()

        if (before.isBlank()) {
            errorBuilder.append("Before can't be empty.")
        }

        if (after.isBlank()) {
            errorBuilder.append("After can't be empty.")
        }

        fun validateAndAppend(key: String, pivotInput: String) {
            for (pivotNode in pivotInput.split("\n")) {
                if (!pivotNode.trim().matches(Core.rowRegex)) {
                    errorBuilder.append("Invalid $key input '$pivotNode'.".also { console.error(it) })
                }
            }
        }

        validateAndAppend("before", before)
        validateAndAppend("after", after)

        return if (errorBuilder.isBlank()) null else errorBuilder.toString()
    }
}

