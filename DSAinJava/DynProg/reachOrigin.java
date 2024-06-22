package DSAinJava.DynProg;

public class reachOrigin {
    public static int ways(int n, int m)
    {
        int[][] dp=new int[n+1][m+1];
        int mod=1000000007;
        // return solve(n,m,dp);
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%mod;
            }
        }
        return dp[n][m];
    }
    private static int solve(int n,int m,int[][] dp) {
        int mod=1000000007;
        if(n==0 || m==0){
            return 1;
        }
        if(dp[n][m]!=0){
            return dp[n][m];
        }

        return dp[n][m]=(solve(n-1,m,dp)+solve(n,m-1,dp))%mod;
    }
}
