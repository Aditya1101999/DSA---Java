package DynProg;
public class ZeroOneKnapsack {
    public static int knapsack(int[] val,int[] wt,int W,int n){
        if(W==0||n==0){
            return 0;
        }
        //valid condition
        if(wt[n-1]<=W){//weight of last element
            int ans1=val[n-1]+knapsack(val,wt,W-wt[n-1],n-1);//include
            int ans2=knapsack(val,wt,W,n-1);//exclude
            return Math.max(ans1,ans2);
        }
        else{//not valid
            return knapsack(val,wt,W,n-1);//exclude
        }
    }
    public static int memo(int[] val,int[] wt,int W,int n,int[][] dp){
        if(W==0||n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        //valid condition
        if(wt[n-1]<=W){//weight of last element
            int ans1=val[n-1]+memo(val,wt,W-wt[n-1],n-1,dp);//include
            int ans2=memo(val,wt,W,n-1,dp);//exclude
            dp[n][W]=Math.max(ans1,ans2);
            return dp[n][W];
        }
        else{//not valid
            dp[n][W]=memo(val,wt,W,n-1,dp);//exclude
            return dp[n][W];
        }
    }
    public static int tab(int[] val,int[] wt,int W){
        int n= val.length;
        int[][] dp=new int[n+1][W+1];
        for(int i=0;i<n+1;i++) {//initialization
            dp[i][0]=0;
        }
        for(int j=0;j<W+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++) {//initialization
            for (int j = 1; j < W + 1; j++) {
                int v=val[i-1];//value of ith item
                int w=wt[i-1];//weight of ith item
                if(w<=j){//valid case
                    int inc=v+dp[i-1][j-w];
                    int exc=dp[i-1][j];
                    dp[i][j]=Math.max(inc,exc);
                }
                else{//invalid case-exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args){
        int[] val={15,14,10,45,30};
        int[] wt={2,5,1,3,4};
        int W=7;
        int[][] dp=new int[val.length+1][W+1];
        for(int i=0;i< dp.length;i++){//initialization
            for(int j=0;j< dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(knapsack(val,wt,W,val.length));
        System.out.println(memo(val,wt,W,val.length,dp));
        System.out.println(tab(val,wt,W));
    }

}
