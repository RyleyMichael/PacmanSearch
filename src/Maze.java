/*
 *
 */

public class Maze {


    //constructor
    public Maze()
    {

    }

    //method to print the maze
    public void printMaze(char[][] matrix)
    {
        //loop through the rows
        for (int row = 0; row < matrix.length; row++)
        {
            //loop through the cols
            for (int col = 0; col < matrix[row].length; col++)
            {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
