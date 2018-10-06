/**
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
        //array list of characters
        ArrayList<ArrayList<Character>> maze = new ArrayList<>();

        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("open_maze.txt"));

            //
            int i = 0;

            //loop through the whole file line-by-line
            while (fileRead.hasNextLine())
            {
                String line = fileRead.nextLine();
                char[] charLine = line.toCharArray();
                maze.add(new ArrayList<>()); //add an array list inside maze

                //get the ith element, which is the second layer of the arrayList, and add it to the inner array list
                for (int j = 0; j < charLine.length; j++)
                {
                    maze.get(i).add(charLine[j]);
                }
                i++; //increment i to the next inner arrayList
            }

            fileRead.close();
        }

        //error is thrown if file cannot be found
        catch (Exception exception)
        {
            System.out.println(exception);
        }

        //convert the maze to a 2d array
        ToArray toarray = new ToArray();
        char[][] openMaze = toarray.convert(maze);
        char[][] openBFS = toarray.convert(maze);
        char[][] openGreedy = toarray.convert(maze);

        //print the array back to the console
        System.out.println("\n\nOriginal Maze");
        PrintArray printarray = new PrintArray();
        printarray.printArray(openMaze);

        //find the starting point of the maze
        FindStart_End start_end = new FindStart_End();
        Node startingCoord = start_end.start(openMaze);
        Node endingCoord = start_end.end(openMaze);

        //perform Breadth-First search on the maze
        BFS bfs = new BFS();
        ArrayList path = bfs.solve(openBFS, startingCoord);
        Object[] pathArray = path.toArray();
        bfs.printPath(pathArray);
        printarray.printArray(openBFS);

        //System.out.println(bfs.solve(array2d, startingCoord));

        // Perform Greedy best-first search on the maze
        Greedy greedy = new Greedy();
        ArrayList greedyPath = greedy.solve(openGreedy, startingCoord, endingCoord);
        Object[] greedyPathArray = greedyPath.toArray();
        greedy.printPath(greedyPathArray);
        printarray.printArray(openGreedy);

        // Perform A* search on the maze

    }
}
