/**
 * Method to perform the Breadth-First search algorithm
 */

//imports
import java.util.LinkedList;
import java.util.ArrayList;

public class BFS {

    //constructor
    public BFS()
    {
        //
    }

    /**
     * Method to solve the maze using Breadth-First search
     * @param maze
     * @param startNode
     * @return
     * THIS METHOD WILL RETURN A PATH OF NODES, probably an arrayList
     */
    public ArrayList solve(char[][] maze, Node startNode)
    {
        //queue representation
        LinkedList<Node> queue = new LinkedList<>();

        //2d array to represent whether a spot has been visited or not
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        //array-list to represent shortest path
        ArrayList<Node> path = new ArrayList<>();

        //add the first node to the queue
        Node currentNode;
        queue.add(startNode);
        visited[startNode.getxCord()][startNode.getyCord()] = true;

        startNode.setParent(startNode);

        //run until the queue is empty
        while (!queue.isEmpty())
        {
            //remove the head of the queue
            currentNode = queue.poll();

            //System.out.println("Node just dequed..\n\txCord : " + currentNode.getxCord() + "\n\tyCord : "
            //        + currentNode.getyCord() + "\n\tcharacter : " + maze[currentNode.getxCord()][currentNode.getyCord()]);

            //check North
            if (maze[currentNode.getxCord() - 1][currentNode.getyCord()] != '%'
                    && !visited[currentNode.getxCord() - 1][currentNode.getyCord()])
            {
                Node northNode = new Node(currentNode.getxCord() - 1, currentNode.getyCord());

                //queue.add(new Node(currentNode.getxCord() - 1, currentNode.getyCord()));

                queue.add(northNode);
                visited[currentNode.getxCord() - 1][currentNode.getyCord()] = true;

                northNode.setParent(currentNode);

                //System.out.println("the parent of (" + northNode.getxCord() + "," + northNode.getyCord()
                //        + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                //check for exit
                if (maze[currentNode.getxCord() - 1][currentNode.getyCord()] == '*')
                {
                    Node pellet = new Node(currentNode.getxCord() - 1, currentNode.getyCord());
                    //System.out.println("pellet has been found at (" + pellet.getxCord() + ","
                    //        + pellet.getyCord() + ")");

                    pellet.setParent(currentNode);
                    return backtrack(pellet, startNode);
                    //break;
                }
            }

            //check East
            if (maze[currentNode.getxCord()][currentNode.getyCord() + 1] != '%'
                    && !visited[currentNode.getxCord()][currentNode.getyCord() + 1])
            {
                Node eastNode = new Node(currentNode.getxCord(), currentNode.getyCord() + 1);

                //queue.add(new Node(currentNode.getxCord(), currentNode.getyCord() + 1));

                queue.add(eastNode);
                visited[currentNode.getxCord()][currentNode.getyCord() + 1] = true;

                eastNode.setParent(currentNode);

                //System.out.println("the parent of (" + eastNode.getxCord() + "," + eastNode.getyCord()
                //        + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                //check for exit
                if (maze[currentNode.getxCord()][currentNode.getyCord() + 1] == '*')
                {
                    Node pellet = new Node(currentNode.getxCord(),currentNode.getyCord() + 1);
                    //System.out.println("pellet has been found at (" + pellet.getxCord() + ","
                    //        + pellet.getyCord() + ")");

                    pellet.setParent(currentNode);
                    return backtrack(pellet, startNode);
                    //break;
                }
            }

            //check South
            if (maze[currentNode.getxCord() + 1][currentNode.getyCord()] != '%'
                    && !visited[currentNode.getxCord() + 1][currentNode.getyCord()])
            {
                Node southNode = new Node(currentNode.getxCord() + 1, currentNode.getyCord());

                //queue.add(new Node(currentNode.getxCord() + 1, currentNode.getyCord()));

                queue.add(southNode);
                visited[currentNode.getxCord() + 1][currentNode.getyCord()] = true;

                southNode.setParent(currentNode);

                //System.out.println("the parent of (" + southNode.getxCord() + "," + southNode.getyCord()
                //        + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                //check for exit
                if (maze[currentNode.getxCord() + 1][currentNode.getyCord()] == '*')
                {
                    Node pellet = new Node(currentNode.getxCord() + 1, currentNode.getyCord());
                    //System.out.println("pellet has been found at (" + pellet.getxCord() + ","
                    //        + pellet.getyCord() + ")");

                    pellet.setParent(currentNode);
                    return backtrack(pellet, startNode);
                    //break;
                }
            }

            //check West
            if (maze[currentNode.getxCord()][currentNode.getyCord() - 1] != '%'
                    && !visited[currentNode.getxCord()][currentNode.getyCord() - 1])
            {
                Node westNode = new Node(currentNode.getxCord(), currentNode.getyCord() - 1);

                //queue.add(new Node(currentNode.getxCord(), currentNode.getyCord() - 1));

                queue.add(westNode);
                visited[currentNode.getxCord()][currentNode.getyCord() - 1] = true;

                westNode.setParent(currentNode);

                //System.out.println("the parent of (" + westNode.getxCord() + "," + westNode.getyCord()
                //        + ") is (" + currentNode.getxCord() + "," + currentNode.getyCord() + ")");

                //check for exit
                if (maze[currentNode.getxCord()][currentNode.getyCord() - 1] == '*')
                {
                    Node pellet = new Node(currentNode.getxCord(),currentNode.getyCord() - 1);
                    //System.out.println("pellet has been found at (" + pellet.getxCord()
                    //        + "," + pellet.getyCord() + ")");

                    pellet.setParent(currentNode);
                    return backtrack(pellet, startNode);
                    //break;
                }
            }
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
