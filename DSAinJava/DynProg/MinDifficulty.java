package DSAinJava.DynProg;
import java.util.Arrays;
public class MinDifficulty {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        if(d>n) return -1;
        int[][] dp=new int[n][d+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        //return solve(0,jobDifficulty,d,dp);
        for(int i=0;i<n;i++){//one day
            int max=0;
            for(int k=i;k<n;k++){
                max=Math.max(max,jobDifficulty[k]);
            }
            dp[i][1]=max;
        }
        for(int i=2;i<=d;i++){//days
            for(int j=0;j<=n-i;j++){//only these jobs are allowed
                int max=Integer.MIN_VALUE;
                int result=Integer.MAX_VALUE;
                for(int idx=j;idx<=n-i;idx++){
                    max=Math.max(max,jobDifficulty[idx]);
                    result=Math.min(result,max+dp[idx+1][i-1]);
                }
                dp[j][i]=result;
            }
        }

        return dp[0][d];
    }
    private int solve(int i,int[] jobDifficulty, int d,int[][] dp){
        int n=jobDifficulty.length;
        if(d==1){
            int max=Integer.MIN_VALUE;
            for(int idx=i;idx<n;idx++){
                max=Math.max(max,jobDifficulty[idx]);
            }
            return dp[i][d]=max;
        }
        if(dp[d][i]!=-1) return dp[i][d];
        int max=Integer.MIN_VALUE;
        int result=Integer.MAX_VALUE;
        for(int idx=i;idx<=n-d;idx++){
            max=Math.max(max,jobDifficulty[idx]);
            result=Math.min(result,max+solve(idx+1,jobDifficulty,d-1,dp));
        }
        return dp[i][d]=result;
    }
}
