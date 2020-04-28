import kotlin.Double.Companion.NEGATIVE_INFINITY

class QTable(private val rows: Int, private val cols: Int) {
    private val table = Array(rows){Array(cols) {0.0} }


    fun set(row: Int, col: Int, value: Double){
        table[row][col] = value
    }
    fun argmax(rowIndex: Int): Int{
        val row = table[rowIndex]
        var maxVal = row[0];
        var index = 0
        for (i in 1 until cols){
            if(row[i] > maxVal){
                maxVal = row[i]
                index = i
            }
        }
        return index
    }
    fun get(row: Int, col: Int): Double = table[row][col]
    fun max(rowIndex: Int): Double{
        var row = table[rowIndex]
        return row.sortedArray().last()
    }
    fun print(){
        table.map { row -> println(row.map { it }) }
    }

}