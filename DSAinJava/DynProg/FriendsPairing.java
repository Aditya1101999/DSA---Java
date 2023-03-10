package DynProg;

public class FriendsPairing {
    public static int pairing(int n){
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2]*(i-1);
        }
        return dp[n];
    }
    public static void main(String args[]){
        System.out.println(pairing(4));
    }
}
