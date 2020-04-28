import kotlin.math.exp
import kotlin.random.Random

class Agent(val learningRate: Double, val discount: Double, val maxSteps: Int, val explorationDecayRate: Double) {
    private val environment = Environment()
    private val qTable = QTable(environment.states, environment.actions)
    private var explorationRate = 1.0
    private val maxExplorationRate = 1.0;

    fun learn(epochs: Int){

        for(i in 0 until epochs){
            environment.reset()
            var finished = false
            var currentReward = 0;
            for(step in 0 until maxSteps){
                val explorationThresholdRate = Math.random()
                var state = environment.getState()
                var action = (0..3).shuffled().first()
                if(explorationThresholdRate > explorationRate){
                    action = qTable.argmax(state)
                }
                var returns = environment.takeAction(action)
                var reward = returns[0]
                finished = returns[1] == 1
                var newState = environment.getState()
                var oldValue = (1-learningRate)*(qTable.get(state, action))
                var learnedValue = learningRate * (reward + discount * qTable.max(newState))
                qTable.set(state, action, oldValue+learnedValue)
                if(finished)
                    break
                explorationRate = maxExplorationRate * exp(-explorationDecayRate*i)
            }
        }
    }
    fun exploit(){
        environment.reset()
        var finished = false;
        while(!finished){
            var state = environment.currentRow * 4 + environment.currentCol
            var action = qTable.argmax(state)
            println("State: (${environment.currentCol}|${environment.currentRow}) Best action:  ${Environment.asWord(action)} Reward for that action: ${qTable.max(state)}")
            finished = environment.takeAction(action)[1] == 1
        }


    }




}