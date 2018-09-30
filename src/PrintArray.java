/**
 * Class to print the array
 */
public class PrintArray
{
    //constructor
    public PrintArray()
    {

    }

    /**
     * Method to print the 2d array
     * @param maze the 2d-array representation of the maze
     */
    public void printArray(char[][] maze)
    {
        //loop through the entire maze
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[0].length; j++)
            {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
