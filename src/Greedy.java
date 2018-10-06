import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class to perform the Greedy Best-First search algorithm
 */

public class Greedy
{
    //constructor
    public Greedy()
    {

    }

    /**
     * Method to solve the maze using Breadth-First search
     * @param maze
     * @param startNode
     * @return
     * THIS METHOD WILL RETURN A PATH OF NODES, probably an arrayList
     */
    public ArrayList solve(char[][] maze, Node startNode, Node endNode)
    {
        //queue representation
        LinkedList<Node> queue = new LinkedList<>();

        //array-list to represent shortest path
        ArrayList<Node> path = new ArrayList<>();

        // Hold north,east,south,west nodes
        Node northNode;
        Node eastNode;
        Node southNode;
        Node westNode;

        // Integer to hold minimum distance from north, east, south, or west node to the end node
        int minDistance;

        // String to track node with minimum distance
        String minNode = "";

        // Instance of DistanceBetween class to find the distance between 2 nodes
        DistanceBetween distanceTo = new DistanceBetween();

        //add the first node to the queue
        Node currentNode;
        queue.add(startNode);
        maze[startNode.getxCord()][startNode.getyCord()] = '.';

        currentNode = startNode;

        startNode.setParent(startNode);

        //run until the queue is empty
        while (!queue.isEmpty())
        {
            // Set north, east, south, and west node from current node
            northNode = new Node(currentNode.getxCord() - 1, currentNode.getyCord());
            eastNode = new Node(currentNode.getxCord(),currentNode.getyCord() + 1);
            southNode = new Node(currentNode.getxCord() + 1, currentNode.getyCord());
            westNode = new Node(currentNode.getxCord(), currentNode.getyCord() - 1);

            // Find minimum distance from surrounding nodes to the endNode
            minDistance = 999999999;        // Set minDistance to approximately infinity
            if (maze[northNode.getxCord()][northNode.getyCord()] != '%' && maze[northNode.getxCord()][northNode.getyCord()] != '.'){
                if (distanceTo.distance(northNode, endNode) < minDistance) {
                    minDistance = distanceTo.distance(northNode, endNode);
                    minNode = "north";
                }
            }
            if (maze[eastNode.getxCord()][eastNode.getyCord()] != '%' && maze[eastNode.getxCord()][eastNode.getyCord()] != '.'){
                if (distanceTo.distance(eastNode, endNode) < minDistance) {
                    minDistance = distanceTo.distance(eastNode, endNode);
                    minNode = "east";
                }
            }
            if (maze[southNode.getxCord()][southNode.getyCord()] != '%' && maze[southNode.getxCord()][southNode.getyCord()] != '.'){
                if (distanceTo.distance(southNode, endNode) < minDistance) {
                    minDistance = distanceTo.distance(southNode, endNode);
                    minNode = "south";
                }
            }
            if (maze[westNode.getxCord()][westNode.getyCord()] != '%' && maze[westNode.getxCord()][westNode.getyCord()] != '.'){
                if (distanceTo.distance(westNode, endNode) < minDistance) {
                    minDistance = distanceTo.distance(westNode, endNode);
                    minNode = "west";
                }
            }
            if (minDistance == 999999999){
                minNode = "none";
            }

            //check North
            if (minNode.equals("north"))
            {
                queue.add(northNode);

                //visited[northNode.getxCord()][northNode.getyCord()] = true;
                if (maze[northNode.getxCord()][northNode.getyCord()] != '*')
                    maze[northNode.getxCord()][northNode.getyCord()] = '.';

                northNode.setParent(currentNode);
                currentNode = northNode;

                //check for exit
                if (maze[northNode.getxCord()][northNode.getyCord()] == '*')
                {
                    Node pellet = new Node(northNode.getxCord(), northNode.getyCord());
                    pellet.setParent(currentNode);
                    return backtrack(pellet, startNode);
                }
            }

            //check East
            else if (minNode.equals("east"))
            {
                queue.add(eastNode);

                //visited[eastNode.getxCord()][eastNode.getyCord()] = true;
                if (maze[eastNode.getxCord()][eastNode.getyCord()] != '*')
                    maze[eastNode.getxCord()][eastNode.getyCord()] = '.';

                eastNode.setParent(currentNode);
                currentNode = eastNode;

                //check for exit
                if (maze[eastNode.getxCord()][eastNode.getyCord()] == '*')
                {
                    Node pellet = new Node(eastNode.getxCord(),eastNode.getyCord());
                    pellet.setParent(currentNode);
                    return backtrack(pellet, startNode);
                }
            }

            //check South
            else if (minNode.equals("south"))
            {
                queue.add(southNode);

                //visited[southNode.getxCord()][southNode.getyCord()] = true;
                if (maze[southNode.getxCord()][southNode.getyCord()] != '*')
                    maze[southNode.getxCord()][southNode.getyCord()] = '.';

                southNode.setParent(currentNode);
                currentNode = southNode;

                //check for exit
                if (maze[southNode.getxCord()][southNode.getyCord()] == '*')
                {
                    Node pellet = new Node(southNode.getxCord(), southNode.getyCord());
                    pellet.setParent(currentNode);
                    return backtrack(pellet, startNode);
                }
            }

            //check West
            else if (minNode.equals("west"))
            {
                queue.add(westNode);

                //visited[westNode.getxCord()][westNode.getyCord()] = true;
                if (maze[westNode.getxCord()][westNode.getyCord()] != '*')
                    maze[westNode.getxCord()][westNode.getyCord()] = '.';

                westNode.setParent(currentNode);
                currentNode = westNode;

                //check for exit
                if (maze[westNode.getxCord()][westNode.getyCord()] == '*')
                {
                    Node pellet = new Node(westNode.getxCord(),westNode.getyCord());
                    pellet.setParent(currentNode);
                    return backtrack(pellet, startNode);
                }
            }
            else
                currentNode = queue.remove();
            PrintArray print = new PrintArray();
            print.printArray(maze);
        }
        return path;
    }

    public ArrayList backtrack(Node endNode, Node startNode)
    {
        ArrayList path = new ArrayList();
        Node nodeToAdd = endNode;

        //backtrack until the starting node is added
        while (nodeToAdd != startNode)
        {
            path.add(nodeToAdd);
            nodeToAdd = nodeToAdd.getParent();
        }

        path.add(startNode);
        return path;
    }

    public void printPath(Object[] path)
    {
        //loop backwards through the array
        for (int i = path.length - 1; i > -1; i--)
        {
            System.out.println(path[i]);
        }
    }
}
