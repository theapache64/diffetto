import kotlinx.serialization.Serializable

data class PivotTableRow(
    val name: String,
    val timestamp: String,
    val timeInMillis: Float,
    val count: Int
)

data class DiffTableRow(
    val name: String,
    val beforeTimestamp: String,
    val afterTimestamp: String,
    val diff: String,
    val countDiff: String,
    var isVisible: Boolean
)

@Serializable
data class PivotData(
    val resultName: String,
    val before: String,
    val after: String
)