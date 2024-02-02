package DSAinJava.DynProg;

public class KInversePairArr {
    public int kInversePairs(int n, int k) {
        int[][] dp=new int[n+1][k+1];
        int mod=(int)1e9+7;
        // for(int i=0;i<n+1;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(dp,n,k);
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;//k=0
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                int ans=0;
                for(int inv=0;inv<=Math.min(i-1,j);inv++){
                    ans=(ans+dp[i-1][j-inv])%mod;
                }
                dp[i][j]=ans;
            }
        }
        return dp[n][k];
    }
    private int solve(int[][] dp,int n ,int k){
        if(n==0){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(dp[n][k]!=-1){
            return dp[n][k];
        }
        int mod=(int)1e9+7;
        int ans=0;
        //inversions possible when nth element is added
        for(int inv=0;inv<=Math.min(n-1,k);inv++){
//when we got inv inversions from this element ,we require the remaining (k-inv) from the (n-1)
            ans=(ans+solve(dp,n-1,k-inv))%mod;
        }
        return dp[n][k]=ans;
    }
}
