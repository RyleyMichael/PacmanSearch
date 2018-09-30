public class PrintArray {
    public PrintArray(){

    }

    public void printArray(char[][] maze){
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
