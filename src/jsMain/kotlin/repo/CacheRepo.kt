package repo

import kotlinx.browser.window
import org.w3c.dom.get
import org.w3c.dom.set

interface CacheRepo {
    fun saveString(key: String, value: String)
    fun getString(key: String): String?
}

class CacheRepoImpl : CacheRepo {
    override fun saveString(key: String, value: String) {
        window.localStorage[key] = value
    }

    override fun getString(key: String): String? {
        return window.localStorage[key]
    }
}