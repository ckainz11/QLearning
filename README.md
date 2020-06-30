# QLearning

Implementation of the Q-Learning algorithm. 

## Environment

The agent is going to learn in the following environment:

![Environment](https://github.com/ckainz11/QLearning/blob/master/images/environment.PNG)
<br>
where S = Start, E = Empty, M = Mine and G = Goal

## Rewards 

For each step, the agent takes, it gets a reward of -1. This prevents it from taking a longer path than necessary.
A mine causes a reward of -100 and the goal a reward of +100

## Strategies

In order to make the agent learn as much as possible in the shortest amount of time, a version of the epsilon greedy strategy was implemented. 
This means, that the agent will exponentially exploit his environment more than exploring it.

## Results

![Result](https://github.com/ckainz11/QLearning/blob/master/images/results.PNG)
<br>
You can see the agent that doesn't go onto the field (2|1), because he has a bad experience with this field as there are tow mines nearby. So not only can the agent find the quickest but also the safest way.

