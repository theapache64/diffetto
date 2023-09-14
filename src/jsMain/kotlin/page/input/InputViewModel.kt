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

class InputViewModel(
    val cacheRepo: CacheRepo
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
            cacheRepo.getString(KEY_BEFORE_CACHE) ?: DEFAULT_BEFORE_INPUT,
            cacheRepo.getString(KEY_AFTER_CACHE) ?: DEFAULT_AFTER_INPUT,
        )
    )
        private set


    var isReadyToShowPivotData by mutableStateOf<Boolean>(false)
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
        isReadyToShowPivotData = true
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
}

