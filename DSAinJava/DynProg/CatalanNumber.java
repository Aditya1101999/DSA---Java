package DynProg;

import java.util.Arrays;

public class CatalanNumber {
    public static int Catalan(int n){
        if(n==0||n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Catalan(i)*Catalan(n-i-1);
        }
        return ans;
    }
    public static int memo(int n,int dp[]){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=memo(i,dp)*memo(n-i-1,dp);
        }
        dp[n]=ans;
        return dp[n];
    }
    public static int tab(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){//ith catalan
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n=4;
        System.out.println(Catalan(n));
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(memo(n,dp));
        System.out.println(tab(n));
    }
}
