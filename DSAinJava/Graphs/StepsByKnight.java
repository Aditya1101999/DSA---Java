package DSAinJava.Graphs;
import java.util.*;
public class StepsByKnight {
    class Pair{
        int row;
        int col;
        int moves;
        public Pair(int row,int col,int moves){
            this.row=row;
            this.col=col;
            this.moves=moves;
        }
    }
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        boolean[][] visited=new boolean[n+1][n+1];//1-based indexing
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(KnightPos[0],KnightPos[1],0));

        int[] delRow={-2,-2,-1,-1,1,1,2,2};
        int[] delCol={-1,1,-2,2,-2,2,-1,1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int moves=q.peek().moves;
            q.remove();
            if(row==TargetPos[0] && col==TargetPos[1]){
                return moves;
            }
            for(int i=0;i<8;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(nrow>=1 && nrow<=n && ncol>=1 && ncol<=n && !visited[nrow][ncol]){
                    visited[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,moves+1));
                }
            }
        }
        return Integer.MAX_VALUE;

    }
}
