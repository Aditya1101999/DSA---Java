package DynProg;
import java.util.*;
public class ClimbingStaris {
    public static int countWays(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return countWays(n-1)+countWays(n-2);
    }
    public static int memo(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){//already calculated
            return dp[n];
        }
        dp[n]=memo(n-1,dp)+memo(n-2,dp);
        return dp[n];
    }
    public static int tab(int n) {
        int[] dp = new int[n + 1];
        //initialization
        dp[0] = 1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public long nthStair(int n)//if order does not matter i.e.{1,2,1} and {1,1,2} are same
    {
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-2]+1;
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n=5;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(countWays(n));
        System.out.println(memo(n,dp));
        System.out.println(tab(n));
    }
}
