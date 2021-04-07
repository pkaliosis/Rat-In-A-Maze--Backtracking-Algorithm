# Rat-In-A-Maze--Backtracking-Algorithm
Implementation(using Java) of one well-known CS problem, the "Rat in a maze", with backtracking. ATTENTION: In Uni we referred to this problem as Thiseas, due to the ancient Greek myth of Thiseas in the labyrinth trying to make his way out. That's why there is a file called Thiseas, which is the main file of the project, aka that is the one that you should runin order to check if the algorithm really works.
So there are 6 .java files that are needed in order to implement this problem with backtracking. Of course someone could use the brute force method, but it would be much more time and memory consuming.
In order to implement the backtracking, we are of course using a stack and a queue. We have created 2 files for the stack and 2 for the queue.

Stack:
  1. StringStack.java : This file contains the definition of the methods used to succesfully build our stack.
  2. StringStackImpl.java : This file implements the methods defined in the above one.

Queue:
  1. StringQueue.java : This file contains the definition of the methods used to succesfully build our queue.
  2. StringQueueImpl.java : This file implements the methods defined in the above one.

Moreover, there is a file named StringQueueWithOnePointer.java, which actually implements a more advanced version of the classic queue, using only one pointer to move from one queue element to another. We created this version as a bonus feature of our project, so anyone who is interested can take a look!

Finally, there is the Thiseas.java file where we use everything that we have already created, and recursively make our way out of the labyrinth. Whoever is interested should give a closer look on method findPath, as it is the point where the backtracking happens.

NOTE: The labyrinth is being given as an input through a txt file, so that's why I have uploaded the thiseas.txt file too.
Its structure is:
#rows #columns
#exitRow #exitColumn
--------------------------
Labyrinth of 0, 1 and E symbols, where 0 is a "wall", 1 is a walkable path and E is the exit point.

