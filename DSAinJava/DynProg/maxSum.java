package DSAinJava.DynProg;

public class maxSum {
    public int maximumSum(int n)
    {
        int[] dp=new int[n+1];

        return solve(n,dp);
    }
    private int solve(int n,int[] dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=0) return dp[n];
        return dp[n]=Math.max(n,Math.max(n/2,solve(n/2,dp))+Math.max(n/3,solve(n/3,dp))+Math.max(n/4,solve(n/4,dp)));
    }
}
