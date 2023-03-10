package DynProg;

public class MinOperations {
    public static int minOperation(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            if(i%2==0){//even
                dp[i]=dp[i/2]+1;
            }
            else{//odd
                dp[i]=dp[i-1]+1;
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        int n=8;

    }
}
