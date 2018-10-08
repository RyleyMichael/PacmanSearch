import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Class to perform the A* search algorithm
 */

public class Astar
{
    //instance variables
    private int numExpanded;

    //constructor
    public Astar()
    {

    }

    /**
     * Method to solve the maze using Greedy Best-First search
     * @param maze
     * @param startNode
     * @return
     * THIS METHOD WILL RETURN A PATH OF NODES, probably an arrayList
     */
    public ArrayList solve(char[][] maze, Node startNode, Node endNode)
    {
        //queue representation
        LinkedList<Node> queue = new LinkedList<>();
        PriorityQueue<Node> pQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node one, Node two)
            {
                return one.gethScore() - two.gethScore();
            }
        });

        //array-list to represent shortest path
        ArrayList<Node> path = new ArrayList<>();

        // Hold north,east,south,west nodes
        Node northNode;
        Node eastNode;
        Node southNode;
        Node westNode;

        // Integer to hold minimum distance from north, east, south, or west node to the end node
        int heuristic;

        // String to track node with minimum distance
        String minNode = "";

        // Instance of DistanceBetween class to find the distance between 2 nodes
        DistanceBetween distanceTo = new DistanceBetween();

        //integer to represent the number of expanded nodes
        numExpanded = 0;

        //add the first node to the queue
        Node currentNode;
        //queue.add(startNode);
        pQueue.add(startNode);
        maze[startNode.getxCord()][startNode.getyCord()] = '.';

        currentNode = startNode;

        startNode.setParent(startNode);

        //make a new PrintArray instance to print the maze after each move
        PrintArray print = new PrintArray();

        //run until the queue is empty
        //while (!queue.isEmpty())
        while (!pQueue.isEmpty())
        {
            //remove the head of the priority queue
            //currentNode = pQueue.poll();

            // Set north, east, south, and west node from current node
            northNode = new Node(currentNode.getxCord() - 1, currentNode.getyCord());
            eastNode = new Node(currentNode.getxCord(),currentNode.getyCord() + 1);
            southNode = new Node(currentNode.getxCord() + 1, currentNode.getyCord());
            westNode = new Node(currentNode.getxCord(), currentNode.getyCord() - 1);

            // Find minimum distance from surrounding nodes to the endNode
            heuristic = 999999999;        // Set minDistance to approximately infinity
            if (maze[northNode.getxCord()][northNode.getyCord()] != '%' && maze[northNode.getxCord()][northNode.getyCord()] != '.') {
                if (distanceTo.distance(northNode, endNode) + distanceTo.distance(northNode, startNode) < heuristic) {
                    heuristic = distanceTo.distance(northNode, endNode) + distanceTo.distance(northNode, startNode);
                    minNode = "north";
                }
            }
            if (maze[eastNode.getxCord()][eastNode.getyCord()] != '%' && maze[eastNode.getxCord()][eastNode.getyCord()] != '.'){
                if (distanceTo.distance(eastNode, endNode) + distanceTo.distance(eastNode, startNode) < heuristic) {
                    heuristic = distanceTo.distance(eastNode, endNode) + distanceTo.distance(eastNode, startNode);
                    minNode = "east";
                }
            }
            if (maze[southNode.getxCord()][southNode.getyCord()] != '%' && maze[southNode.getxCord()][southNode.getyCord()] != '.'){
                if (distanceTo.distance(southNode, endNode) + distanceTo.distance(southNode, startNode) < heuristic) {
                    heuristic = distanceTo.distance(southNode, endNode) + distanceTo.distance(southNode, startNode);
                    minNode = "south";
                }
            }
            if (maze[westNode.getxCord()][westNode.getyCord()] != '%' && maze[westNode.getxCord()][westNode.getyCord()] != '.'){
                if (distanceTo.distance(westNode, endNode) + distanceTo.distance(westNode, startNode) < heuristic) {
                    heuristic = distanceTo.distance(westNode, endNode) + distanceTo.distance(westNode, startNode);
                    minNode = "west";
                }
            }
            if (heuristic == 999999999){
                minNode = "none";
            }

            //check North
            if (minNode.equals("north"))
            {
                //queue.add(northNode);
                pQueue.add(northNode);

                //visited[northNode.getxCord()][northNode.getyCord()] = true;
                if (maze[northNode.getxCord()][northNode.getyCord()] != '*')
                    //mark the spot visited and update the number of expanded nodes
                    maze[northNode.getxCord()][northNode.getyCord()] = '.';
                    numExpanded++;

                northNode.setParent(currentNode);

                //System.out.println("the parent of (" + northNode.getxCord() + "," + northNode.getyCord()
                //        + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                currentNode = northNode;

                //check for exit
                if (maze[northNode.getxCord()][northNode.getyCord()] == '*')
                {
                    Node pellet = new Node(northNode.getxCord(), northNode.getyCord());
                    pellet.setParent(currentNode);

                    maze[pellet.getxCord()][pellet.getyCord()] = '.';
                    numExpanded++;
                    System.out.println("\nSolution Maze via A* Search");
                    print.printArray(maze);

                    return backtrack(pellet, startNode, maze);
                }
            }

            //check East
            else if (minNode.equals("east"))
            {
                //queue.add(eastNode);
                pQueue.add(eastNode);

                //visited[eastNode.getxCord()][eastNode.getyCord()] = true;
                if (maze[eastNode.getxCord()][eastNode.getyCord()] != '*')
                    maze[eastNode.getxCord()][eastNode.getyCord()] = '.';
                    numExpanded++;

                eastNode.setParent(currentNode);

                //System.out.println("the parent of (" + eastNode.getxCord() + "," + eastNode.getyCord()
                //        + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                currentNode = eastNode;

                //check for exit
                if (maze[eastNode.getxCord()][eastNode.getyCord()] == '*')
                {
                    Node pellet = new Node(eastNode.getxCord(),eastNode.getyCord());
                    pellet.setParent(currentNode);

                    maze[pellet.getxCord()][pellet.getyCord()] = '.';
                    numExpanded++;
                    System.out.println("\nSolution Maze via A* Search");
                    print.printArray(maze);

                    return backtrack(pellet, startNode, maze);
                }
            }

            //check South
            else if (minNode.equals("south"))
            {
                //queue.add(southNode);
                pQueue.add(southNode);

                //visited[southNode.getxCord()][southNode.getyCord()] = true;
                if (maze[southNode.getxCord()][southNode.getyCord()] != '*')
                    maze[southNode.getxCord()][southNode.getyCord()] = '.';
                    numExpanded++;

                southNode.setParent(currentNode);

                //System.out.println("the parent of (" + southNode.getxCord() + "," + southNode.getyCord()
                //       + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                currentNode = southNode;

                //check for exit
                if (maze[southNode.getxCord()][southNode.getyCord()] == '*')
                {
                    Node pellet = new Node(southNode.getxCord(), southNode.getyCord());
                    pellet.setParent(currentNode);

                    maze[pellet.getxCord()][pellet.getyCord()] = '.';
                    numExpanded++;
                    System.out.println("\nSolution Maze via A* Search");
                    print.printArray(maze);

                    return backtrack(pellet, startNode, maze);
                }
            }

            //check West
            else if (minNode.equals("west"))
            {
                //queue.add(westNode);
                pQueue.add(westNode);

                //visited[westNode.getxCord()][westNode.getyCord()] = true;
                if (maze[westNode.getxCord()][westNode.getyCord()] != '*')
                    maze[westNode.getxCord()][westNode.getyCord()] = '.';
                    numExpanded++;

                westNode.setParent(currentNode);

                //System.out.println("the parent of (" + westNode.getxCord() + "," + westNode.getyCord()
                //        + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                currentNode = westNode;

                //check for exit
                if (maze[westNode.getxCord()][westNode.getyCord()] == '*')
                {
                    Node pellet = new Node(westNode.getxCord(),westNode.getyCord());
                    pellet.setParent(currentNode);

                    maze[pellet.getxCord()][pellet.getyCord()] = '.';
                    numExpanded++;
                    System.out.println("\nSolution Maze via A* Search");
                    print.printArray(maze);

                    return backtrack(pellet, startNode, maze);
                }
            }
            else
            {
                currentNode = pQueue.remove();
                //currentNode = pQueue.poll();
            }

            //PrintArray print = new PrintArray();
            //print.printArray(maze);
        }

        System.out.println("\nSolution Maze via A* Search");
        print.printArray(maze);
        return path;
    }

    /**
     * Method to backtrack through the path
     * @param endNode the goal state
     * @param startNode the initial state
     * @return the path from the initial state to the goal state
     */
    public ArrayList backtrack(Node endNode, Node startNode, char[][] maze)
    {
        ArrayList path = new ArrayList();
        Node nodeToAdd = endNode;

        //backtrack until the starting node is added
        while (nodeToAdd != startNode)
        {

            //path.add(nodeToAdd);
            path.add(nodeToAdd);
            nodeToAdd = nodeToAdd.getParent();
        }

        path.add(startNode);
        return path;
    }

    /**
     * Method to print the number of expanded nodes and the length of the path
     * @param path
     */
    public void printPath(Object[] path)
    {
        //loop backwards through the array; skipping the first element because the goal state is being added twice
        /*for (int i = path.length - 1; i > 0; i--)
        {
            System.out.println(path[i]);
        }*/

        //subtracting one to leave out the initial state
        System.out.println("The number of steps taken to get from the initial state to the goal state is " + (path.length - 2));
        System.out.println("The number of nodes expanded by A* Search is " + numExpanded + "\n");
    }
}
