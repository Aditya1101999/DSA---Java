package DSAinJava.DynProg;
import java.util.Arrays;
public class CoinAccumulation {
    public static boolean isPossible(int N, int[] coins) {
        int sum=Arrays.stream(coins).sum();
        boolean[][] dp=new boolean[N+1][sum+1];
        //return solve(coins,0,0,dp);
        //state , dp[i][j]-> sum of j is achiveable by i coins
        for(int i=0;i<N+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<sum+1;j++){
                if(j>=coins[i-1]){//include or exclude
                    dp[i][j]=dp[i-1][j-coins[i-1]]||dp[i-1][j];
                }
                else {//exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int j=1;j<sum+1;j++){
            if(isValidSum(j) && dp[N][j]) return true;
        }
        return false;
    }
    private static boolean solve(int[] coins,int index,int sum,boolean[][] dp){
        if(index==coins.length){
            return dp[index][sum]=(sum!=0) && isValidSum(sum);
        }
        if (dp[index][sum]) {
            return dp[index][sum];
        }
        boolean exclude=solve(coins,index+1,sum,dp);
        boolean include=solve(coins,index+1,sum+coins[index],dp);
        return dp[index][sum]=(include||exclude);
    }
    private static boolean isValidSum(int sum){
        return (sum%20==0)||(sum%24==0)||(sum==2024);
    }
}
