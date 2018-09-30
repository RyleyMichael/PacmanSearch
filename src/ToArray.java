/**
 * Class to convert the array list
 */

//imports
import java.util.ArrayList;

public class ToArray
{
    //constructor
    public ToArray ()
    {

    }

    /**
     * Method to convert a two-layered array list into a two-dimensional array
     * @param maze the arrayList representation of the maze
     * @return the 2d array representation of the maze
     */
    public char[][] convert(ArrayList<ArrayList<Character>> maze)
    {
        int rows = maze.size();
        int columns = maze.get(0).size();
        char[][] newMaze = new char[rows][columns];

        //loop through the entire maze
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                newMaze[i][j] = maze.get(i).get(j);
            }
        }

        return newMaze;
    }
}
