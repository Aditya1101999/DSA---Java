package DSAinJava.Graphs;
import java.util.*;
public class NoOfEnclaves {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 ||j==n-1){//boundary values
                    if(!visited[i][j] && grid[i][j]==1){
                        q.add(new Pair(i,j));
                        visited[i][j]=true;
                    }
                }
            }
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(nrow>0 && nrow<m && ncol>0 && ncol<n && !visited[nrow][ncol] && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol));
                    visited[nrow][ncol]=true;
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1) count++;
            }
        }
        return count;
    }
}
