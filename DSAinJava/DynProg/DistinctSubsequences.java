package DSAinJava.DynProg;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve(s,t,n,m,dp);
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
    private int solve(String s,String t,int i,int j,int[][] dp){
        if(j==0) return 1;//t exhausted
        if(i==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=solve(s,t,i-1,j-1,dp)+solve(s,t,i-1,j,dp);
        }
        return dp[i][j]=solve(s,t,i-1,j,dp);
    }
}
