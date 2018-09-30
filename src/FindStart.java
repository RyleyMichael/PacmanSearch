/**
 * Class to find the starting point of the maze
 */

public class FindStart
{
    //constructor
    public FindStart()
    {

    }

    /**
     * Method to find the starting point in the maze, denoted by a P
     * @param maze the array representation of the maze
     * @return the starting point as an array
     */
    public int[] start(char[][] maze){
        int[] start = new int[2];

        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                if (maze[i][j] == 'P'){
                    start[0] = i;
                    start[1] = j;
                    return start;
                }
            }
        }
        return start;
    }
}
