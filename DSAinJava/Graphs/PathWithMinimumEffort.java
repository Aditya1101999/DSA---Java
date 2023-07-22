package DSAinJava.Graphs;
import java.util.*;
public class PathWithMinimumEffort {
    class Tuple{
        int difference;
        int x;
        int y;
        public Tuple(int difference,int x,int y){
            this.difference=difference;
            this.x=x;
            this.y=y;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dis=new int[n][m];
        PriorityQueue<Tuple>pq=new PriorityQueue<>((a,b)->a.difference-b.difference);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j]=(int)(1e9);
            }
        }
        dis[0][0]=0;
        pq.add(new Tuple(0,0,0));
        while(!pq.isEmpty()){
            int difference=pq.peek().difference;
            int row=pq.peek().x;
            int col=pq.peek().y;
            pq.remove();
            if(row==n-1 && col==m-1) return difference;//smallest distance possible
            int[] delRow={-1,0,1,0};
            int[] delCol={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m){
                    int newEffort=Math.max(difference,Math.abs(heights[nrow][ncol]-heights[row][col]));
                    if(newEffort<dis[nrow][ncol]){
                        dis[nrow][ncol]=newEffort;
                        pq.add(new Tuple(newEffort,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}
