package DSAinJava.Graphs;
import java.util.*;
public class MaxSafenessFactor {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        int[][] manhattenDistance=new int[n][n];
        boolean[][] visited=new boolean[n][n];
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){//thief
                    visited[i][j]=true;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            int dis=curr[2];
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && !visited[nrow][ncol]){
                    visited[nrow][ncol]=true;
                    q.add(new int[]{nrow,ncol,dis+1});
                    manhattenDistance[nrow][ncol]=dis+1;
                }
            }
        }
        //binary search on safeness factor
        int low=0;
        int high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isSafe(manhattenDistance,mid)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
    private boolean isSafe(int[][] manhattenDistance,int safeFactor){
        int n=manhattenDistance.length;
        if(manhattenDistance[0][0]<safeFactor || manhattenDistance[n-1][n-1]<safeFactor) return false;
        Queue<int[]>q=new LinkedList<>();
        boolean[][] visited=new boolean[n][n];
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        q.add(new int[]{0,0});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            if(row==n-1 && col==n-1) return true;
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && !visited[nrow][ncol] && manhattenDistance[nrow][ncol]>=safeFactor){
                    visited[nrow][ncol]=true;
                    q.add(new int[]{nrow,ncol});
                }
            }
        }
        return false;
    }
}
