import kotlinx.serialization.Serializable

sealed class PivotTableTime {
    data class Float(val value: kotlin.Float) : PivotTableTime()
    data object DidNotEnd : PivotTableTime()
}

data class PivotTableRow(
    var name: String,
    val timestamp: String,
    val timeInMillis: PivotTableTime,
    val count: Int
)

data class DiffTableRow(
    val name: String,
    val beforeTimeInMs : String,
    val afterTimeInMs : String,
    val diff: Long?,
    val beforeCount : Int,
    val afterCount : Int,
    val countDiff: String,
    var isLargest: Boolean,
    var isSmallest: Boolean
)

@Serializable
data class PivotData(
    val resultName: String,
    val before: String,
    val after: String
)