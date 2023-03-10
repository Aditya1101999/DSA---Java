package DynProg;

public class UnboundedKnapsack {
    public static int tab(int[] val,int[] wt,int W){
        int[][] dp=new int[val.length+1][W+1];
        for(int i=0;i< dp.length;i++) {//initialization
            dp[i][0]=0;
        }
        for(int j=0;j< dp[0].length;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<val.length+1;i++) {//initialization
            for (int j = 1; j < W + 1; j++) {
                int v=val[i-1];//value of ith item
                int w=wt[i-1];//weight of ith item
                if(w<=j){//valid case
                    int inc=v+dp[i][j-w];
                    int exc=dp[i-1][j];
                    dp[i][j]=Math.max(inc,exc);
                }
                else{//invalid case-exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[val.length][W];
    }
    public static void main(String[] args){
        int[] val={15,14,10,45,30};
        int[] wt={2,5,1,3,4};
        int W=7;
        System.out.println(tab(val,wt,7));
    }
}
