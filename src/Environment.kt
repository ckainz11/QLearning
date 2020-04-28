class Environment {
    val environment  = arrayOf(
        arrayOf('S', 'E', 'E', 'E'), // S = Start
        arrayOf('E', 'M', 'M', 'E'), // E = Empty Reward = -1
        arrayOf('M', 'M', 'E', 'E'), // M = Mine Reward = -10
        arrayOf('G', 'E', 'E', 'E')  // G = Goal Reward = 100
    )
    val states = 16
    val actions = 4
    var currentRow = 0
    var currentCol = 0

    constructor()

    companion object{
        fun asWord(action: Int): String{
            return when(action) {
                0 -> "Up"
                1 -> "Right"
                2 -> "Down"
                3 -> "Left"
                else -> "Not an action"
            }
        }
    }

    // 0 = up, 1 = right, 2 = down, 3 = left
    // return = reward, finished

    fun takeAction(action: Int): Array<Int>{
        var outOfBoundsReward = 0
        when(action){
            0-> {
                if(currentRow == 0) {outOfBoundsReward = -20} else {currentRow-=1}
            }
            1-> {
                if(currentCol == environment[currentRow].size-1) {outOfBoundsReward =-20} else {currentCol += 1}
            }
            2-> {
                if(currentRow == environment.size-1) {outOfBoundsReward =-20} else {currentRow += 1}
            }
            3->{
                if(currentCol == 0) {outOfBoundsReward = -20} else {currentCol-=1}
            }
            else -> throw IllegalArgumentException("Action has to be 1, 2, 3 or 4! Action was: {$action}")
        }
        var reward = getReward()+outOfBoundsReward
        return arrayOf(reward, if(reward==100) {1} else {0})
    }
    private fun getReward(): Int{
        return when(environment[currentRow][currentCol]){
            'G' -> 100
            'M' -> -100
            else -> -1
        }
    }
    fun reset(){
        currentCol = 0
        currentRow = 0
    }
    fun getState(): Int{
        return currentRow*4 + currentCol
    }
    fun getRow(): Int = currentRow
    fun getCol(): Int = currentCol






}