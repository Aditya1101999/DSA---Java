package DSAinJava.Graphs;
import java.util.*;
class HighestPeakMap {
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        int[][] ans=new int[m][n];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j] == 1){
                    ans[i][j]=0;
                    q.add(new Pair(i,j));
                }
                else{
                    ans[i][j]=-1;
                }
            }
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int x=row+delRow[i];
                int y=col+delCol[i];
                if(x>=0 && x<m && y>=0 && y<n && ans[x][y]==-1){//not updated yet
                    ans[x][y]=ans[row][col]+1;
                    q.add(new Pair(x,y));
                }
            }
        }
        return ans;
    }
}
