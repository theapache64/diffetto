package core

import PivotTableRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import repo.PrefRepo

abstract class Filter(
    val uniqueKey: String,
    private val isValuePreserved: Boolean,
    private val defaultValue: Boolean,
    private val prefRepo: PrefRepo
) {
    abstract fun apply(list: List<PivotTableRow>): List<PivotTableRow>

    var isEnabled by mutableStateOf(
        (if (isValuePreserved) prefRepo.get(uniqueKey)?.toBoolean() else defaultValue) ?: defaultValue
    )
        private set

    fun setEnabled(isEnabled: Boolean) {
        if (isValuePreserved) {
            prefRepo.set(uniqueKey, isEnabled.toString())
        }
        this.isEnabled = isEnabled
    }
}