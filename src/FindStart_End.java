/**
 * Class to find the starting point of the maze
 */

public class FindStart_End
{
    //constructor
    public FindStart_End()
    {

    }

    /**
     * Method to find the starting point in the maze, denoted by a 'P'
     * @param maze the array representation of the maze
     * @return the starting point as a Node
     */
    public Node start(char[][] maze){
        Node startNode = new Node(0,0);

        //loop over the entire maze
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[0].length; j++)
            {
                if (maze[i][j] == 'P')
                {
                    startNode = new Node(i, j);
                    return startNode;
                }
            }
        }
        return startNode;
    }

    /**
     * Method to find the ending point in the maze, denoted by a '*'
     * @param maze the array representation of the maze
     * @return the starting point as a Node
     */
    public Node end(char[][] maze){
        Node endNode = new Node(0,0);

        //loop over the entire maze
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[0].length; j++)
            {
                if (maze[i][j] == '*')
                {
                    endNode = new Node(i, j);
                    return endNode;
                }
            }
        }
        return endNode;
    }
}