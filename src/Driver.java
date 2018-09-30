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
        ArrayList<ArrayList<Character>> maze = new ArrayList<>();

        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("open_maze.txt"));

            int i = 0;

            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();
                char[] charLine = line.toCharArray();
                maze.add(new ArrayList<>());
                for (int j = 0; j < charLine.length; j++){
                    maze.get(i).add(charLine[j]);
                }
                i++;
            }
            //Maze open = new Maze();
            //open.printMaze(maze);
            fileRead.close();
        }
        //error is thrown if file cannot be found
        catch (Exception exception)
        {
            System.out.println(exception);
        }

        ToArray toarray = new ToArray();
        char[][] array2d = toarray.convert(maze);

        PrintArray printarray = new PrintArray();
        printarray.printArray(array2d);

        FindStart findstart = new FindStart();
        int[] startingCoords = findstart.start(array2d);






    }
}
