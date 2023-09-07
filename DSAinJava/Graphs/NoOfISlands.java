package DSAinJava.Graphs;
import java.util.*;
public class NoOfISlands {
    class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    count++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
    private void bfs(int row,int col,char[][] grid,boolean[][] vis){
        vis[row][col]=true;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(row,col));
        int n=grid.length;
        int m=grid[0].length;
        int[] rows = {-1, 0, 1, 0};//row directions
        int[] cols = {0, 1, 0, -1};//col directions
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + rows[i];
                int ncol = c + cols[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
}
