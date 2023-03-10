package DynProg;

public class Tribonacci {
    public static void TibTabulation(int n){
        int[] dp=new int[n+1];
        //initialization
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
    }
    public static void main(String[] args){
        int n=10;
        TibTabulation(n);
    }

}
