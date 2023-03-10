package Backtracking;

public class RatMaze {
    public static boolean ratMaze(int[][] maze, int x, int y, int[][] sol) {
        int N = maze.length;
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            //maze value in solution matrix
            sol[x][y] = 1;
            return true;
        }
        if(isSafe(maze, x, y)){
            //base case
            if(sol[x][y]==1){
                //already visited but no more path
                return false;
            }
            sol[x][y]=1;
            if(ratMaze(maze,x+1,y,sol)){
                return true;
            }
            if(ratMaze(maze,x,y+1,sol)){
                return true;
            }
            //backtracking step
            sol[x][y]=0;
            return false;
        }
        return false;
    }

    public static void printSol(int[][] sol) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int[][] maze, int x, int y) {
        //checking whether indexes are in maze
        //along with whether path is safe
        return x >= 0 && x < maze.length && y >= 0 && y < maze.length &&
                maze[x][y] == 1;
    }
    public static void solveMaze(int[][] maze){
        int N=maze.length;
        int[][] sol=new int[N][N];
        if(ratMaze(maze,0,0,sol)) {
            printSol(sol);
        }
    }
    public static void main(String[] args){
        int[][] maze={{1,0,0,0},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}};
        solveMaze(maze);
    }
}

