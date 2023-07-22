package DSAinJava.Graphs;
import java.util.*;
public class ShortestPathMatrix {
    static class Tuple{
        int distance;
        int x;
        int y;
        public Tuple(int distance,int x,int y){
            this.distance=distance;
            this.x=x;
            this.y=y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0) return -1;
        if(n==1) return 1;
        int[][] dis=new int[n][n];
        boolean[][] vis=new boolean[n][n];
        Queue<Tuple>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        dis[0][0]=0;
        vis[0][0]=true;
        q.add(new Tuple(1, 0, 0));
        int[] delRow={-1,-1,0,1,1,1,0,-1};
        int[] delCol={0,1,1,1,0,-1,-1,-1};
        while(!q.isEmpty()){
            int u=q.peek().distance;
            int x=q.peek().x;
            int y=q.peek().y;
            if (x== n - 1 && y == n - 1) return u;
            q.remove();
            for(int i=0;i<8;i++){
                int nrow=x+delRow[i];
                int ncol=y+delCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && !vis[nrow][ncol] &&
                        u+1<dis[nrow][ncol]){
                    dis[nrow][ncol]=u+1;
                    q.add(new Tuple(dis[nrow][ncol], nrow, ncol));
                    vis[nrow][ncol]=true;
                }
            }
        }
        return -1;
    }

}
