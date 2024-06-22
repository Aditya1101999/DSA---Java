package DSAinJava.arrays;

public class findWinnerGame {
    public static int findWinner(int n, int x, int y) {
        boolean[] dp=new boolean[n+1];
        dp[1]=true;
        for(int i=2;i<n+1;i++){
            if(!dp[i-1]) dp[i]=true;
            else if(i-x>=0 &&  !dp[i-x]) dp[i]=true;
            else if(i-y>=0 && !dp[i-y]) dp[i]=true;
        }
        return dp[n] ? 1 : 0 ;
    }
}
