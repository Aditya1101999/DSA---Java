package DSAinJava.DynProg;
import java.util.Arrays;
public class MobNumericKeypad {
    public long getCount(int n) {
        int[][] moves={{1,2,3},
                {4,5,6},
                {7,8,9},
                {-1,0,-1}};
        //You can start from any digit.
        long[][] dp=new long[n+1][10];
        for(long[] row : dp){
            Arrays.fill(row,-1);
        }
        long result=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(moves[i][j]!=-1){
                    result+=solve(moves,n,moves[i][j],i,j,dp);
                }
            }
        }
        return result;
    }
    private long solve(int[][] moves,int n,int number,int row,int col,long[][] dp){
        if(n==1) return 1;
        if(dp[n][number]!=-1) return dp[n][number];
        int[] delRow={-1,0,1,0};
        int[] delCol={0,-1,0,1};
        long result=solve(moves,n-1,number,row,col,dp);
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && ncol>=0 && nrow<moves.length && ncol<moves[0].length && moves[nrow][ncol]!=-1){
                result+=solve(moves,n-1,moves[nrow][ncol],nrow,ncol,dp);
            }
        }
        return dp[n][number]=result;
    }
}
