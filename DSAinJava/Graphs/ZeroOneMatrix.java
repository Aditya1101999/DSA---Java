package DSAinJava.Graphs;
import java.util.*;
public class ZeroOneMatrix {
    class Pair{
        int row;
        int col;
        int dis;
        public Pair(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Pair>q=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int dis=q.peek().dis;
            ans[row][col]=dis;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && !visited[nrow][ncol] && mat[nrow][ncol]==1){
                    visited[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,dis+1));
                }
            }
        }
        return ans;
    }
}
