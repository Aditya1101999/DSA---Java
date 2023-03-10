package DynProg;

public class CoinChnage {
    public int coinChange(int[] coins, int amount) {// no. of coins
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<amount+1;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }
            else dp[0][i] = (int)Math.pow(10,9);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<amount+1;j++){
                int notTake=dp[i-1][j];
                int take=(int)Math.pow(10,9);
                if(coins[i]<=j){
                    take=1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(notTake,take);
            }
        }
        int ans= dp[n-1][amount];
        if(ans >=(int)Math.pow(10,9)) return -1;
        return ans;
    }
    public static int tab(int[] coins,int sum){//no. of combinations
        int n= coins.length;
        int[][] dp=new int[n+1][sum+1];
        //i=ith coin
        //j=sum/change
        for(int i=0;i<n+1;i++) {//initialization
            dp[i][0]=1;//null set
        }
        for(int j=0;j<sum+1;j++){
            dp[0][j]=0;//if no coins
        }
        for(int i=1;i<n+1;i++) {//initialization
            for (int j = 1; j < sum + 1; j++) {
                int v = coins[i - 1];//value of ith item
                if(v<=j) {//valid case
                    dp[i][j]=dp[i][j-v]+dp[i-1][j];
                }
                else{//invalid case
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args){
        int[] coins={2,5,3,6};
        int sum=10;
        System.out.println(tab(coins,sum));
    }
}
