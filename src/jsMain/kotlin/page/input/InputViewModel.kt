package page.input

import Core
import PivotData
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.browser.window
import org.w3c.dom.url.URL
import repo.CacheRepo
import kotlin.js.Date

const val KEY_RESULT = "result"

class InputViewModel(
    private val cacheRepo: CacheRepo
) {

    companion object {
        private const val KEY_BEFORE_CACHE = "before_cache"
        private const val KEY_AFTER_CACHE = "after_cache"

    }


    var errorMsg by mutableStateOf("")
        private set

    var pivotData by mutableStateOf(
        PivotData(
            "",
            cacheRepo.getString(KEY_BEFORE_CACHE) ?: "",
            cacheRepo.getString(KEY_AFTER_CACHE) ?: "",
        )
    )
        private set

    var isReadyToShowPivotData by mutableStateOf<Boolean>(window.location.search.contains(KEY_RESULT))
        private set

    fun onBeforeInputChanged(newInput: String) {
        pivotData = pivotData.copy(before = newInput)
        cacheRepo.saveString(KEY_BEFORE_CACHE, newInput)
    }

    fun onAfterInputChanged(newInput: String) {
        pivotData = pivotData.copy(after = newInput)
        cacheRepo.saveString(KEY_AFTER_CACHE, newInput)
    }

    fun onButtonClicked() {
        val errorMsg = pivotData.validate()
        if (errorMsg != null) {
            // update error message state
            this.errorMsg = errorMsg
            return
        }

        var name = window.prompt("Give it a name!")
        if (name.isNullOrBlank()) {
            name = Date().toString()
        }
        pivotData = pivotData.copy(resultName = name)
        onBeforeInputChanged(newInput = pivotData.before)
        onAfterInputChanged(newInput = pivotData.after)
        isReadyToShowPivotData = true
        window.history.replaceState("", "", "?$KEY_RESULT");
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
            for (pivotNode in pivotInput.split("\n").filter { it.trim().isNotBlank() }) {
                if (!pivotNode.trim().matches(Core.rowRegex)) {
                    errorBuilder.append("Invalid $key input '$pivotNode'.".also { console.error(it) })
                }
            }
        }

        validateAndAppend("before", before)
        validateAndAppend("after", after)

        return if (errorBuilder.isBlank()) null else errorBuilder.toString()
    }

    fun onFillSampleDataCLicked() {
        pivotData = pivotData.copy(
            before = DEFAULT_BEFORE_INPUT,
            after = DEFAULT_AFTER_INPUT
        )
    }
}

fun onTitleClicked() {
    // go to home page while keeping current page in history
    window.location.href = URL(window.location.href.replace(KEY_RESULT, "")).href
}

