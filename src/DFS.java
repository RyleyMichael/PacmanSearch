import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class to perform the Depth-First search algorithm
 */

public class DFS {

    //instance variables
    int numExpanded;

    //constructor
    public DFS()
    {

    }

    /**
     * Method to solve the maze using Depth-First search
     * @param maze the maze as a 2d char matrix
     * @param startNode the location of P in the maze; represented by a (x,y) pair
     * @return the path of nodes as an array list
     */
    public ArrayList solve(char[][] maze, Node startNode)
    {
        //stack representation
        LinkedList<Node> stack = new LinkedList();

        //2d array to represent visited nodes
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        //array list to represent shortest path
        ArrayList<Node> path = new ArrayList<>();

        //integer to represent the number of expanded nodes
        numExpanded = 0;

        //push the first node to the stack and mark it visited
        Node currentNode;
        stack.push(startNode);
        visited[startNode.getxCord()][startNode.getyCord()] = true;

        //set the parent of the start node to itself
        startNode.setParent(startNode);

        //Print Array instance to print the maze after each move
        PrintArray print = new PrintArray();

        //run until the stack is empty
        while (!stack.isEmpty())
        {
            //remove the head of the stack
            currentNode = stack.pop();

            //mark the current node visited and update the number of expanded nodes
            maze[currentNode.getxCord()][currentNode.getyCord()] = '.';
            numExpanded++;

            /*
             * Check the North maze square for a wall or visited node
             */
            if (maze[currentNode.getxCord() - 1][currentNode.getyCord()] != '%'
                    && !visited[currentNode.getxCord() - 1][currentNode.getyCord()])
            {
                //push the north node onto the stack and mark it visited
                Node northNode = new Node(currentNode.getxCord() - 1, currentNode.getyCord());
                stack.push(northNode);
                visited[currentNode.getxCord() - 1][currentNode.getyCord()] = true;

                //set the parent of the north node
                northNode.setParent(currentNode);

                //System.out.println("the parent of (" + northNode.getxCord() + "," + northNode.getyCord()
                //        + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                //check for exit
                if (maze[currentNode.getxCord() - 1][currentNode.getyCord()] == '*')
                {
                    Node pellet = new Node(currentNode.getxCord() - 1, currentNode.getyCord());

                    //set the parent node
                    pellet.setParent(currentNode);

                    //mark the pellet visited and update the number of expanded nodes
                    maze[pellet.getxCord()][pellet.getyCord()] = '.';
                    numExpanded++;
                    System.out.println("\nSolution maze via Depth-First Search");
                    print.printArray(maze);

                    //call backtrack to return the lowest-cost path through the maze
                    return backtrack(pellet, startNode);
                }
            }

            /*
             * Check the East maze square for a wall or visited node
             */
            if (maze[currentNode.getxCord()][currentNode.getyCord() + 1] != '%'
                    && !visited[currentNode.getxCord()][currentNode.getyCord() + 1])
            {
                //push the north node onto the stack and mark it visited
                Node eastNode = new Node(currentNode.getxCord(), currentNode.getyCord() + 1);
                stack.push(eastNode);
                visited[currentNode.getxCord()][currentNode.getyCord() + 1] = true;

                eastNode.setParent(currentNode);

                //System.out.println("the parent of (" + eastNode.getxCord() + "," + eastNode.getyCord()
                //                + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                //check for exit
                if (maze[currentNode.getxCord()][currentNode.getyCord() + 1] == '*')
                {
                    Node pellet = new Node(currentNode.getxCord(), currentNode.getyCord() + 1);

                    pellet.setParent(currentNode);

                    maze[pellet.getxCord()][pellet.getyCord()] = '.';
                    numExpanded++;
                    System.out.println("\nSolution maze via Depth-First Search");
                    print.printArray(maze);

                    return backtrack(pellet, startNode);
                }
            }

            /*
             * Check the South maze square for a wall or visited node
             */
            if (maze[currentNode.getxCord() + 1][currentNode.getyCord()] != '%'
                    && !visited[currentNode.getxCord() + 1][currentNode.getyCord()])
            {
                //push the north node onto the stack and mark it visited
                Node southNode = new Node(currentNode.getxCord() + 1, currentNode.getyCord());
                stack.push(southNode);
                visited[currentNode.getxCord() + 1][currentNode.getyCord()] = true;

                southNode.setParent(currentNode);

                //System.out.println("the parent of (" + southNode.getxCord() + "," + southNode.getyCord()
                //                + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                //check for exit
                if (maze[currentNode.getxCord() + 1][currentNode.getyCord()] == '*')
                {
                    Node pellet = new Node(currentNode.getxCord() + 1, currentNode.getyCord());

                    pellet.setParent(currentNode);

                    maze[pellet.getxCord()][pellet.getyCord()] = '.';
                    numExpanded++;
                    System.out.println("\nSolution maze via Depth-First Search");
                    print.printArray(maze);

                    return backtrack(pellet, startNode);
                }
            }

            /*
             * Check the West maze square for a wall or visited node
             */
            if (maze[currentNode.getxCord()][currentNode.getyCord() - 1] != '%'
                    && !visited[currentNode.getxCord()][currentNode.getyCord() - 1])
            {
                //push the north node onto the stack and mark it visited
                Node westNode = new Node(currentNode.getxCord(), currentNode.getyCord() - 1);
                stack.push(westNode);
                visited[currentNode.getxCord()][currentNode.getyCord() - 1] = true;

                westNode.setParent(currentNode);

                //System.out.println("the parent of (" + westNode.getxCord() + "," + westNode.getyCord()
                //                + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                //check for exit
                if (maze[currentNode.getxCord()][currentNode.getyCord() - 1] == '*')
                {
                    Node pellet = new Node(currentNode.getxCord(), currentNode.getyCord() - 1);

                    pellet.setParent(currentNode);

                    maze[pellet.getxCord()][pellet.getyCord()] = '.';
                    numExpanded++;
                    System.out.println("\nSolution maze via Depth-First Search");
                    print.printArray(maze);

                    return backtrack(pellet, startNode);
                }
            }
            //print.printArray(maze);
        }

        System.out.println("Solution maze via Depth-First Search");
        print.printArray(maze);
        return path;
    }

    /**
     * Method to backtrack through the parent's of visited nodes
     * @param endNode the goal state
     * @param startNode the initial state
     * @return the lowest-cost path through the maze
     */
    public ArrayList backtrack(Node endNode, Node startNode)
    {
        ArrayList path = new ArrayList();
        Node nodeToAdd = endNode;

        //backtrack until the starting node is added
        while (nodeToAdd != startNode)
        {
            //add the node to the path and get the next node
            path.add(nodeToAdd);
            nodeToAdd = nodeToAdd.getParent();
        }

        //add the starting node last
        path.add(startNode);
        return path;
    }

    /**
     * Method to loop backwards through the path array and print out nodes
     * @param path a list of visited nodes in reverse order
     */
    public void printPath(Object[] path)
    {
        //loop backwards through the array
        /*for (int i = path.length - 1; i > -1; i--)
        {
            //print out the node as a (x,y) pair
            System.out.println(path[i]);
        }*/

        //subtracting one to leave out the initial state
        System.out.println("The number of steps taken to get from the initial state to the goal state is " + (path.length - 1));
        System.out.println("The number of nodes expanded by Depth-First Search is " + numExpanded + "\n");
    }
}
