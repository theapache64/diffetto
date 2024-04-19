interface BaseFilter {
    fun apply(name : String): String?
    fun enabled() : Boolean
}