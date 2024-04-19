package core

import BaseFilter
import PivotTableRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import repo.PrefRepo

abstract class Filter(
    val title: String,
    private val isValuePreserved: Boolean,
    private val defaultValue: Boolean,
    private val prefRepo: PrefRepo
) : BaseFilter {

    var isEnabled by mutableStateOf(
        (if (isValuePreserved) prefRepo.get(title)?.toBoolean() else defaultValue) ?: defaultValue
    )
        private set

    fun setEnabled(isEnabled: Boolean) {
        if (isValuePreserved) {
            prefRepo.set(title, isEnabled.toString())
        }
        this.isEnabled = isEnabled
    }

    override fun enabled(): Boolean {
        return isEnabled
    }
}