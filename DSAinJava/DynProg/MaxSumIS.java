package DynProg;

public class MaxSumIS {
    public static int maxSumIS(int arr[], int n)  {
        int[] dp=new int[n];
        int max=arr[0];
        for(int i=0;i<n;i++){
            dp[i]=arr[i];
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        int N = 5, arr[] = {1, 101, 2, 3, 100};
        System.out.println(maxSumIS(arr,N));
    }
}
