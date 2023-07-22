package DSAinJava.Graphs;
import java.util.*;
public class SwimRisingWater {
    class Tuple{
        int time;
        int x;
        int y;
        public Tuple(int time,int x,int y){
            this.time=time;
            this.x=x;
            this.y=y;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        PriorityQueue<Tuple>pq=new PriorityQueue<>((a,b)->a.time-b.time);
        int leastTime=grid[0][0];
        pq.add(new Tuple(leastTime,0,0));
        visited[0][0]=true;
        while(!pq.isEmpty()){
            int currTime=pq.peek().time;
            int row=pq.peek().x;
            int col=pq.peek().y;
            pq.remove();
            leastTime=Math.max(leastTime,currTime);
            if(row==n-1 && col==n-1) return leastTime;
            int[] delRow={-1,0,1,0};
            int[] delCol={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && !visited[nrow][ncol]){
                    visited[nrow][ncol]=true;
                    pq.add(new Tuple(grid[nrow][ncol],nrow,ncol));
                }
            }
        }
        return leastTime;
    }
}
