object Core {

    fun PivotTableTime.toNumber(): Long {
        return when (this) {
            is PivotTableTime.Float -> value.toLong()
            is PivotTableTime.DidNotEnd -> -1
        }
    }

    fun diff(beforeTable: List<PivotTableRow>, afterTable: List<PivotTableRow>): List<DiffTableRow> {
        val diffList = mutableListOf<DiffTableRow>()

        val names = beforeTable.map { it.name }.toMutableList()
            .apply { addAll(afterTable.map { it.name }) }
            .toSet()

        for (name in names) {

            val oldRows = beforeTable.filter { it.name == name }
            val newRows = afterTable.filter { it.name == name }
            var diffInMs: Long? = null


            when {
                oldRows.isNotEmpty() && newRows.isNotEmpty() -> {
                    diffInMs = (newRows.sumOf {
                        it.timeInMillis.toNumber().zeroIfMinusOne()
                    } - oldRows.sumOf { it.timeInMillis.toNumber().zeroIfMinusOne() })
                }

                newRows.isNotEmpty() -> {
                    diffInMs = newRows.sumOf { it.timeInMillis.toNumber().zeroIfMinusOne() }
                }

                oldRows.isNotEmpty() -> {
                    diffInMs = -oldRows.sumOf { it.timeInMillis.toNumber().zeroIfMinusOne() }
                }
            }

            val oldCount = if (oldRows.isEmpty()) {
                -1
            } else {
                oldRows.sumOf { it.count }
            }
            val newCount = if (newRows.isEmpty()) {
                -1
            } else {
                newRows.sumOf { it.count }
            }

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

            val beforeTimeInMs = when {
                oldRows.isEmpty() -> {
                    "-"
                }
                oldRows.isAllDidNotEnd() -> {
                    "Did not end"
                }
                else -> {
                    oldRows.sumOf { it.timeInMillis.toNumber().zeroIfMinusOne() }.let {
                        "$it"
                    }
                }
            }

            val afterTimeInMs = when {
                newRows.isEmpty() -> {
                    "-"
                }
                newRows.isAllDidNotEnd() -> {
                    "Did not end"
                }
                else -> {
                    newRows.sumOf { it.timeInMillis.toNumber().zeroIfMinusOne() }.let {
                        "$it"
                    }
                }
            }

            val diffRow = DiffTableRow(
                name = name,
                beforeTimeInMs = beforeTimeInMs,
                afterTimeInMs = afterTimeInMs,
                diff = diffInMs,
                beforeCount = oldCount,
                afterCount = newCount,
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

    val rowRegex = "(?<name>.+)\\t(?<timestamp>.+)\\t(?<x>.+)\\t(?<count>\\d+).*".toRegex()

    fun String.toTable(): List<PivotTableRow> {
        val rows = mutableListOf<PivotTableRow>()
        split("\n")
            .map { line -> line.trim() }
            .filter { line -> line.isNotBlank() }
            .forEach { line ->
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


    private fun parseTimestampToMilliseconds(timestamp: String): PivotTableTime {
        if (timestamp == "(Did not end)") return PivotTableTime.DidNotEnd
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
        return PivotTableTime.Float(milliseconds)
    }

    private fun Long.zeroIfMinusOne() : Long {
        return if (this == -1L) 0 else this
    }

    private fun List<PivotTableRow>.isAllDidNotEnd(): Boolean {
        return all { it.timeInMillis == PivotTableTime.DidNotEnd }
    }
}




