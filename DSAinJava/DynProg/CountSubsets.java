package DSAinJava.DynProg;

public class CountSubsets {
    public int perfectSum(int arr[],int n, int sum) {
        int[][] dp=new int[n+1][sum+1];
        int count=1;//null set
        dp[0][0]=count;
        for(int i=1;i<n+1;i++){
            if(arr[i-1]==0){
/*everytime we encounter 0 , the count increases by a factor of 2 =>
1st zero => {},{0} 2nd zero => {} , {1st0} , {2nd0} , {1st0 2nd0} */
                count*=2;
            }
            dp[i][0]=count;
        }
        int mod= (int)1e9+7;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int value=arr[i-1];
                if(value<=j){//include+exclude
                    dp[i][j]=(dp[i-1][j-value]+dp[i-1][j])%mod;
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
