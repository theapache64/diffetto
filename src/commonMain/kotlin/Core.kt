object Core {

    // TODO : Refactor
    fun generateFullHtml(
        name: String,
        diffTableHtml: String
    ): String {
        return """
        <!DOCTYPE html>
        <html>
        <head>
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link href=https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css rel=stylesheet>
          <link href=https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.16.0/bootstrap-table.min.css rel=stylesheet>
          
        </head>
        <body>

        <div class="container-fluid">
          <h2>$name</h2> 
          <p>Type something in the input field to search the table :</p>  
          <input class="form-control" id="myInput" type="text" placeholder="Search..">
          </br>
          <div class="table-responsive"> 
          <table class="table table-bordered" data-toggle=table>
            <thead>
              <tr>
                <th data-sortable=true>Name</th>
                <th data-sortable=true>Before</th>
                <th data-sortable=true>After</th>
                <th data-sortable=true>Diff (in ms)</th>
                <th data-sortable=true>Count diff</th>
              </tr>
            </thead>
            <tbody id="myTable">
              $diffTableHtml
            </tbody>
          </table>
          </div>
        </div>

        <script src=https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js></script>
        <script src=https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.16.0/bootstrap-table.min.js></script>
        
        <script>
        ${'$'}(document).ready(function(){
          ${'$'}("#myInput").on("keyup", function() {
            var value = ${'$'}(this).val().toLowerCase();
            ${'$'}("#myTable tr").filter(function() {
              ${'$'}(this).toggle(${'$'}(this).text().toLowerCase().indexOf(value) > -1)
            });
          });
        });
        </script>

        </body>
        </html>
    """.trimIndent()
    }

    fun diff(beforeTable: List<PivotTableRow>, afterTable: List<PivotTableRow>): List<DiffTableRow> {
        val diffList = mutableListOf<DiffTableRow>()

        val names = beforeTable.map { it.name }.toMutableList()
            .apply { addAll(afterTable.map { it.name }) }
            .toSet()

        for (name in names) {

            val oldRow = beforeTable.find { it.name == name }
            val newRow = afterTable.find { it.name == name }
            var diffInMs = "-"


            if (oldRow != null && newRow != null) {
                diffInMs = "${newRow.timeInMillis - oldRow.timeInMillis}"
            }

            val oldCount = oldRow?.count ?: -1
            val newCount = newRow?.count ?: -1

            val diffCount = when {
                oldCount == newCount -> "0"
                oldCount > 0 && newCount == -1 -> "Removed"
                oldCount == -1 && newCount > 0 -> "Added"
                else -> (newCount - oldCount).toString()
            }

            val diffRow = DiffTableRow(
                name,
                oldRow?.timestamp ?: "-",
                newRow?.timestamp ?: "-",
                diffInMs,
                diffCount
            )

            diffList.add(diffRow)
        }

        return diffList
    }

    val rowRegex = "(?<name>.+)\\s(?<timestamp>.+)\\s(?<x>.+)\\s(?<count>\\d+)\\sarrow_right".toRegex()

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
                        parseTimestampToNano(timestamp),
                        count.toInt()
                    )
                )
            } ?: error("Couldn't parse '$line'")
        }
        return rows
    }

    fun parseTimestampToMilliseconds(timestamp: String): Long {
        var milliseconds = 0L
        val parts = timestamp.split(" ")
        for (part in parts) {
            val unit = part.replace("\\d".toRegex(), "")
            val value = part.replace(unit, "").toLong()
            val valueInMs = when (unit) {
                "s" -> value * 1000L
                "ms" -> value
                "us" -> value / 1000L
                "ns" -> value / 1_000_000L
                else -> error("Unhandled unit '$unit'")
            }
            milliseconds += valueInMs
        }
        return milliseconds
    }

    fun parseTimestampToNano(timestamp: String): Long {
        var milliseconds = 0L
        val parts = timestamp.split(" ")
        for (part in parts) {
            val unit = part.replace("\\d".toRegex(), "")
            val value = part.replace(unit, "").toLong()
            val valueInMs = when (unit) {
                "s" -> value * 1_000_000_000L
                "ms" -> value * 1_000_000L
                "us" -> value * 1_000L
                "ns" -> value
                else -> error("Unhandled unit '$unit'")
            }
            milliseconds += valueInMs
        }
        return milliseconds
    }
}
