import kotlin.math.roundToInt

object Core {

    fun diff(beforeTable: List<PivotTableRow>, afterTable: List<PivotTableRow>): List<DiffTableRow> {
        val diffList = mutableListOf<DiffTableRow>()

        val names = beforeTable.map { it.name }.toMutableList()
            .apply { addAll(afterTable.map { it.name }) }
            .toSet()

        for (name in names) {

            val oldRow = beforeTable.find { it.name == name }
            val newRow = afterTable.find { it.name == name }
            var diffInMs: Int? = null


            if (oldRow != null && newRow != null) {
                diffInMs = (newRow.timeInMillis - oldRow.timeInMillis).roundToInt()
            }

            val oldCount = oldRow?.count ?: -1
            val newCount = newRow?.count ?: -1

            val diffCount = when {
                oldCount == newCount -> "0"
                oldCount > 0 && newCount == -1 -> "Removed ($oldCount)"
                oldCount == -1 && newCount > 0 -> "Added ($newCount)"
                else -> {
                    val diff = (newCount - oldCount)
                    when {
                        diff > 0 -> "$diff (added)"
                        diff < 0 -> "$diff (removed)"
                        else -> "no change"
                    }
                }
            }

            val diffRow = DiffTableRow(
                name = name,
                beforeTimestamp = oldRow?.timestamp ?: "-",
                afterTimestamp = newRow?.timestamp ?: "-",
                diff = diffInMs,
                countDiff = diffCount,
                isLargest = false,
                isSmallest = false
            )

            diffList.add(diffRow)
        }

        if (diffList.isNotEmpty()) {
            // Finding largest
            diffList
                .filter { it.diff != null }
                .maxByOrNull { it.diff ?: error("diff can't be null") }
                ?.isLargest = true

            diffList
                .filter { it.diff != null }
                .minByOrNull { it.diff ?: error("diff can't be null") }
                ?.isSmallest = true
        }

        return diffList
    }

    val rowRegex = "(?<name>.+)\\t(?<timestamp>.+)\\t(?<x>.+)\\t(?<count>\\d+)\\tarrow_right".toRegex()

    fun String.toTable(): List<PivotTableRow> {
        val rows = mutableListOf<PivotTableRow>()
        split("\n").forEach { line ->
            rowRegex.find(line)?.let {
                val (name, timestamp, _, count) = it.destructured
                rows.add(
                    PivotTableRow(
                        name,
                        timestamp,
                        parseTimestampToMilliseconds(timestamp),
                        count.toInt()
                    )
                )
            } ?: error("Couldn't parse '$line'")
        }
        return rows
    }


    private fun parseTimestampToMilliseconds(timestamp: String): Float {
        var milliseconds = 0f
        val parts = timestamp.split(" ")
        for (part in parts) {
            val unit = part.replace("\\d".toRegex(), "")
            val value = part.replace(unit, "").toLong()
            val valueInMs = when (unit) {
                "s" -> value * 1000f // second
                "ms" -> value.toFloat() // milli
                "us" -> (value / 1000f)
                "ns" -> (value / 1_000_000f)
                else -> error("Unhandled unit '$unit'")
            }
            milliseconds += valueInMs
        }
        return milliseconds
    }
}
