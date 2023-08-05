import kotlinx.serialization.Serializable

data class PivotTableRow(
    val name: String,
    val timestamp: String,
    val timeInMillis: Long,
    val count: Int
)

data class DiffTableRow(
    val name: String,
    val beforeTimestamp: String,
    val afterTimestamp: String,
    val diff: String,
    val countDiff: String
)

@Serializable
data class PivotData(
    val resultName : String,
    val before : String,
    val after : String
)