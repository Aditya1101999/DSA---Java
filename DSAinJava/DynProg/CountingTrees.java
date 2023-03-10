package DynProg;

public class CountingTrees {
    public static int tab(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                //dp[j]->ways for left
                //dp[i-j-1]->ways for right
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n=3;
        System.out.println(tab(n));
    }
}
