package DynProg;
public class MaxProfit {
    public static int maxProfit(int[] arr){
        int min=arr[0];
        int maxProfit=0;
        int n= arr.length;
        for(int i=1;i<n;i++){
            int profit=arr[i]-min;
            maxProfit=Math.max(maxProfit,profit);
            min=Math.min(min,arr[i]);
        }
        return maxProfit;
    }
    public static int maxProfit2(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
    public static int maxprofit2(int[] prices){//with cooldown
        int n=prices.length;
        if(n<2) return 0;
        int[] buy=new int[n];
        int[] profit=new int[n];
        buy[0]=-prices[0];
        buy[1]=-Math.min(prices[0],prices[1]);

        profit[1]=Math.max(buy[0]+prices[1],0);
        for(int i=2;i<n;i++){
            buy[i]=Math.max(buy[i-1],profit[i-2]-prices[i]);
            profit[i]=Math.max(profit[i-1],buy[i-1]+prices[i]);
        }
        return profit[n-1];
    }
    public static int maxprofit3(int index,int buy ,int[] prices,int limit){
        if(index==prices.length||limit==0){
            return 0;
        }
        int profit=0;
        if(buy==1){//buy
            int buydo=-prices[index]+maxprofit3(index+1, 0, prices,limit);
            int skip=0+maxprofit3(index+1,1,prices,limit);
            profit=Math.max(buydo,skip);
        }
        else{//sell
            int sell=prices[index]+maxprofit3(index+1,1,prices,limit-1);
            int skip=0+maxprofit3(index+1,0,prices,limit-1);
            profit=Math.max(sell,skip);
        }
        return profit;
    }
    public static int tab3(int[] arr){
//        if(index==prices.length||limit==0){
//            return 0;
//        }
        int n= arr.length;
        int[][][] dp=new int[n+1][2][3];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int limit=1;limit<=2;limit++){
                    if(buy==1){
                        int buydo=-arr[i]+dp[i+1][0][limit];
                        int skip=0+dp[i+1][1][limit];
                        dp[i][buy][limit]=Math.max(buydo,skip);
                    }
                    else{
                        int sell=arr[i]+dp[i+1][1][limit-1];
                        int skip=0+dp[i+1][0][limit-1];
                        dp[i][buy][limit]=Math.max(sell,skip);
                    }
                }
            }
        }
        //answer at 1st index
        return dp[0][1][2];
    }
    public static int maxprofit5(int index,int buy ,int[] prices,int fee) {
        if (index == prices.length) {
            return 0;
        }
        int profit = 0;
        if (buy == 1) {
            int buydo = -prices[index] + maxprofit5(index + 1, 0, prices,fee);
            int skip = 0 + maxprofit5(index + 1, 1, prices,fee);
            profit = Math.max(buydo, skip);
        } else {
            int sell = (prices[index]-fee) + maxprofit5(index + 1, 1, prices,fee);
            int skip = 0 + maxprofit5(index + 1, 0, prices,fee);
            profit = Math.max(sell, skip);
        }
        return profit;
    }
    public static int maxProfit5(int[] prices,int fee) {
//        if(index==prices.length){
//            return 0;
//        }
//        int profit = 0;
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int buydo = -prices[i] + dp[i + 1][0];
                    int skip = 0 + dp[i + 1][1];
                    dp[i][buy] = Math.max(buydo, skip);
                } else {
                        int sell = prices[i] - fee + dp[i + 1][1];
                        int skip = 0 + dp[i + 1][0];
                        dp[i][buy] = Math.max(sell, skip);
                }
            }
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println("maxprofit is " +
                maxProfit(arr));
        System.out.println("maxprofit2 is "+
                maxProfit2(arr));
        System.out.println("maxprofit with cooldown is "+
                maxprofit2(arr));
        System.out.println("maxprofit3 is "+
                maxprofit3(0,1,arr,2));
        System.out.println("maxprofit3 is "+
                tab3(arr));
        System.out.println("maxprofit with transaction "+
                maxprofit5(0,1,arr,2));
        System.out.println("maxprofit with transaction "+
                maxProfit5(arr,2));
    }
}
