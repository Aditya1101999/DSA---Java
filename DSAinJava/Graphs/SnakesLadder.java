package Graphs;
import java.util.*;
public class SnakesLadder {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int steps=0;
        Queue<Integer>q=new LinkedList<>();
        boolean[][] visited=new boolean[n][n];
        q.add(1);
        visited[n-1][0]=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){//all reachable indices
                int x=q.remove();//current board value
                if(x==n*n){
                    return steps;
                }
                for(int j=1;j<=6;j++){//all dice moves
                    if(x+j>n*n){
                        break;
                    }
                    int[] pos=findCoordinates(x+j,n);
                    int row=pos[0];
                    int col=pos[1];
                    if(!visited[row][col]){
                        visited[row][col]=true;
                        if(board[row][col]==-1){//normal cell
                            q.add(x+j);
                        }
                        else{//snake or ladder
                            q.add(board[row][col]);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public int[] findCoordinates(int curr, int n) {
        int r = n - (curr - 1) / n  -1;
        int c = (curr - 1) % n;
        if (r % 2 == n % 2) {//row and n both are either odd/even
            return new int[]{r, n - 1 - c};
        } else {
            return new int[]{r, c};
        }
    }
}
