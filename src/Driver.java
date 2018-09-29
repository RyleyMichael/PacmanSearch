/*
 * Ryley Rodriguez & Connor Grace
 * CSCI 446 - Artificial Intelligence
 * Fall 2018
 */

//imports for scanning and file reading
import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args)
    {
        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("open_maze.txt"));
            fileRead.useDelimiter("");

            ArrayList<ArrayList<Character>> maze = new ArrayList<>();
            int i = 0;

            while (fileRead.hasNextLine()) {
                maze.add(new ArrayList<>());
                while (fileRead.hasNext()) {
                    maze.get(i).add(fileRead.next().charAt(0));
                }
                i++;
            }
            Maze open = new Maze();
            open.printMaze(maze);
            fileRead.close();
        }
        //error is thrown if file cannot be found
        catch (Exception exception)
        {
            System.out.println(exception);
        }


    }
}
