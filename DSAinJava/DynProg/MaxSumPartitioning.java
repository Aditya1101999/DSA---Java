package DSAinJava.DynProg;

public class MaxSumPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return solve(arr,k,0,dp);
        //dp[i]=Maximum sum for the partition arr of size i
        for(int i=0;i<n+1;i++){
            int currMax=0;
            for(int j=1;j<=k && i-j>=0;j++){
                currMax=Math.max(currMax,arr[i-j]);
                dp[i]=Math.max(dp[i],currMax*j+dp[i-j]);
            }
        }
        return dp[n];
    }
    private int solve(int[] arr,int k,int index,int[] dp){
        if(index==arr.length){
            return 0;
        }
        if(dp[index]!=-1) return dp[index];
        int ans=0;
        int currMax=0;
        for(int j=index;j-index<k && j<arr.length;j++){
            currMax=Math.max(currMax,arr[j]);
            ans=Math.max(ans,currMax*(j-index+1)+solve(arr,k,j+1,dp));
        }
        return dp[index]=ans;
    }
}
