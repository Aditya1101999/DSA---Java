package DynProg;
public class DoTroTiling {
    public static int numTilings(int n) {
        if(n==1||n==2) return n;
        int mod=1000000007;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;//2+3
        for(int i=4;i<n+1;i++){
            dp[i]=(2*dp[i-1]%mod+dp[i-3]%mod)%mod;
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(numTilings(5));
    }
}
