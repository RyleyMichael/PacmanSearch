import java.util.ArrayList;

public class ToArray {
    public ToArray (){

    }

    public char[][] convert(ArrayList<ArrayList<Character>> maze){
        int rows = maze.size();
        int columns = maze.get(0).size();
        char[][] newMaze = new char[rows][columns];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                newMaze[i][j] = maze.get(i).get(j);
            }
        }

        return newMaze;
    }
}
