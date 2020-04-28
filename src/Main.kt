fun main(){
    val agent = Agent(0.1, 0.99, 100, 0.01)
    agent.learn(10000)
    agent.exploit()
}