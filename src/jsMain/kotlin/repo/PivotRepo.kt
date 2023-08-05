package repo

import PivotData
import kotlinx.browser.window
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.get

interface PivotRepo {
    fun savePivotData(pivotData: PivotData): String
    fun getPivotData(key: String): PivotData?
}

class PivotRepoImpl : PivotRepo {

    override fun savePivotData(pivotData: PivotData): String {
        val key = generateRandomString(20)
        window.localStorage.setItem(key, Json.encodeToString(pivotData))
        return key
    }

    override fun getPivotData(key: String): PivotData? {
        val jsonString = window.localStorage[key] ?: return null
        return Json.decodeFromString(jsonString)
    }

    private fun generateRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9') // Add any other characters you want to include
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}