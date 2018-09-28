/*
 * Ryley Rodriguez & Connor Grace
 * CSCI 446 - Artificial Intelligence
 * Fall 2018
 */

//imports for scanning and file reading
import java.util.Scanner;
import java.io.FileReader;

public class Driver {

    public static void main(String[] args)
    {
        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("open_maze.txt"));

            //first two lines are the number of rows and columns
            int numRows = fileRead.nextInt();
            int numCols = fileRead.nextInt();

            char[][] maze = new char[numRows][numCols];

            //sets position to beginning of next line
            fileRead.nextLine();

            //loop through the whole maze
            for (int row = 0; row < numRows; row++)
            {

                //read the character in and store it in the array
                char[] line = fileRead.nextLine().toCharArray();
                for (int i = 0; i < line.length; i++)
                {
                    maze[row][i] = line[i];
                }
            }

            Maze instance = new Maze();
            instance.printMaze(maze);

            fileRead.close();
        }

        //error is thrown if file cannot be found
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
}
