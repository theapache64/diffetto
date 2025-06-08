object Core {

    fun PivotTableTime.toNumber(): Long {
        return when (this) {
            is PivotTableTime.Float -> value.toLong()
            is PivotTableTime.DidNotEnd -> -1
        }
    }

    fun diff(
        beforeTable: Map<String, List<PivotTableRow>>,
        afterTable: Map<String, List<PivotTableRow>>
    ): List<DiffTableRow> {
        val diffList = mutableListOf<DiffTableRow>()

        val names = beforeTable.keys + afterTable.keys

        for (name in names) {

            val oldRows = beforeTable[name] ?: emptyList()
            val newRows = afterTable[name] ?: emptyList()
            println("QuickTag: Core:diff: oldRows: ${oldRows.size} newRows: ${newRows.size}")
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

            val beforeTimeInMs = getTimeValue(oldRows)
            val afterTimeInMs = getTimeValue(newRows)

            val diffRow = DiffTableRow(
                name = name,
                beforeTimeInMs = beforeTimeInMs,
                afterTimeInMs = afterTimeInMs,
                diff = diffInMs,
                beforeCount = oldCount,
                afterCount = newCount,
                countDiff = diffCount,
            )

            diffList.add(diffRow)
        }

        return diffList
    }

    private fun getTimeValue(oldRows: List<PivotTableRow>) = when {
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

    val rowRegex = "(?<name>.+)\\t(?<timestamp>.+)\\t(?<count>\\d+).*".toRegex()

    fun String.toTable(filters: List<BaseFilter>): Map<String, List<PivotTableRow>> {
        val rows = mutableMapOf<String, MutableList<PivotTableRow>>()
        split("\n")
            .map { line -> line.trim() }
            .filter { line -> line.isNotBlank() }
            .forEach { line ->
                rowRegex.find(line)?.let {
                    val (name, timestamp, count) = it.destructured
                    val filteredName = name.apply(filters)
                    if (filteredName != null) {
                        val list = rows.getOrPut(
                            filteredName
                        ) { mutableListOf() }
                        list.add(
                            PivotTableRow(
                                filteredName,
                                timestamp,
                                parseTimestampToMilliseconds(timestamp),
                                count.toInt()
                            )
                        )
                    }
                } ?: error("Couldn't parse '$line'")
            }
        return rows
    }

    private fun String.apply(filters: List<BaseFilter>): String? {
        var value = this
        for (filter in filters) {
            if (filter.enabled()) {
                val newValue = filter.apply(value) ?: return null
                value = newValue
            }
        }
        return value
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

    private fun Long.zeroIfMinusOne(): Long {
        return if (this == -1L) 0 else this
    }

    private fun List<PivotTableRow>.isAllDidNotEnd(): Boolean {
        return all { it.timeInMillis == PivotTableTime.DidNotEnd }
    }
}




