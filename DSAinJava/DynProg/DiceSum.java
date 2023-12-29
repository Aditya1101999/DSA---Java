package DSAinJava.DynProg;
import java.util.Arrays;
public class DiceSum {
    public int numRollsToTarget(int n, int k, int target) {
        int mod=(int)1e9+7;
        int[][] dp=new int[n+1][target+1];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return solve(n,k,target,dp);
        dp[0][0]=1;
        for(int i=1;i<n+1;i++){//dices
            for(int j=1;j<target+1;j++){//target
                int ways=0;
                for(int f=1;f<=k;f++){
                    if(f<=j){
                        ways = (ways + dp[i-1][j-f]) % mod;
                    }
                }
                dp[i][j]=ways;
            }
        }
        return dp[n][target];
    }
    private int solve(int n,int k,int target,int[][] dp){
        int mod=(int)1e9+7;
        if(target<0 || n<0) return 0;
        if(target==0 && n==0) return 1;
        if(dp[n][target]!=-1) return dp[n][target];
        int ways=0;
        for(int i=1;i<=k;i++){
            ways = (ways + solve(n - 1, k, target - i, dp)) % mod;
        }
        return dp[n][target]=ways;
    }
}
