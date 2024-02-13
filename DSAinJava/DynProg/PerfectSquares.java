package DSAinJava.DynProg;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return solve(n,dp);
        for(int i=1;i<=n;i++){
            dp[i]=i;
            for(int j=1;j*j<=i;j++){
                int sqSum=j*j;
                dp[i]=Math.min(dp[i],1+dp[i-sqSum]);
            }
        }
        return dp[n];
    }
    private int solve(int n,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=n;
        for(int i=1;i*i<=n;i++){
            int sqSum=i*i;
            ans=Math.min(ans,1+solve(n-sqSum,dp));
        }
        return dp[n]=ans;
    }
}
