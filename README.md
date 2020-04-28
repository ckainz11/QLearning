# QLearning

Implementation of the Q-Learning algorithm. 

## Environment

I've set up the following environment, in which our agent is going to learn:

![Environment](https://github.com/ckainz11/QLearning/blob/master/images/environment.PNG)
where S = Start, E = Empty, M = Mine and G = Goal

## Rewards 

For each step, the agent takes, he gets a reward of -1. This is so that he takes the quickest path.
A Mine cause a reward of -100 and the goal a reward of +100

## Strategies

In order to make the Agent learn as much as possible, I've implemented a version of the epsilon greedy strategy. 
The agent will exponentially exploit his environment more than exploring it.

## Results

![Result](https://github.com/ckainz11/QLearning/blob/master/images/results.PNG)

