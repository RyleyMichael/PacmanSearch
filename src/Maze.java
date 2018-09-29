/*
 *
 */

import java.util.ArrayList;

public class Maze {


    //constructor
    public Maze()
    {

    }

    //method to print the maze
    public void printMaze(ArrayList<ArrayList<Character>> maze)
    {
        int rows = maze.size();
        int columns = maze.get(0).size();

        for (int i = 0; i < rows; i++){
            Object[] line = maze.get(i).toArray();
            for (int j = 0; j < columns; j++){
                System.out.print(line[j]);
            }
            System.out.println();
        }
    }
}
