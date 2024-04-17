package core

data class ErrorUi(
    val title : String,
    val stacktrace : String? = null
)