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
        while(!q.isEmpty()){
            int ro=q.peek().first;
            int co=q.peek().second;
            q.remove();

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nrow=ro+i;
                    int ncol=co+j;
                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&
                            !vis[nrow][ncol]&&grid[nrow][ncol]=='1'){
                        vis[nrow][ncol]=true;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
}
