public class FindStart {
    public FindStart(){

    }

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
