package DynProg;

public class MountainRanges {
    public static int tab(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            //i pairs->mountain ranges
            for(int j=0;j<i;j++){
             //dp[j]->inside pairs
             //dp[i-j-1]->outside pairs
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n=4;//pairs
        System.out.println(tab(n));
    }
}
