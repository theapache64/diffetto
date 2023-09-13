package repo

import kotlinx.browser.window
import org.w3c.dom.get

interface PrefRepo {
    fun set(key: String, value: String)
    fun get(key: String): String?
}

class PrefRepoImpl : PrefRepo {
    override fun set(key: String, value: String) {
        window.localStorage.setItem(key, value)
    }

    override fun get(key: String): String? {
        return window.localStorage[key]
    }
}