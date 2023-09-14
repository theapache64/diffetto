import kotlinx.serialization.Serializable

data class PivotTableRow(
    var name: String,
    val timestamp: String,
    val timeInMillis: Float,
    val count: Int
)

data class DiffTableRow(
    val name: String,
    val beforeTimeInMs : String,
    val afterTimeInMs : String,
    val diff: Long?,
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