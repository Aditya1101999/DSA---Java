package DynProg;
import java.util.*;
import java.util.HashSet;
public class LISubseq {
    public static int tab(int[] arr){
        //to store only unique elements
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int[] arr2=new int[set.size()];
        int i=0;
        for (int num:set) {
            arr2[i]=num;
            i++;
        }
        Arrays.sort(arr2);
        return lcs(arr,arr2);
    }
    public static int lcs(int[] arr1,int[] arr2){
        int n= arr1.length;
        int m= arr2.length;
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int ans1=dp[i][j-1];
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        return helper(nums,n,-1,0,dp);
    }
    public int helper(int[] nums,int n,int prevIndex,int index,int[][] dp) {
        if (index == n) {
            return 0;
        }
        if (dp[index][prevIndex + 1] != -1) {//prevIndex starting from -1
            return dp[index][prevIndex + 1];
        }
        int len = helper(nums, n, prevIndex, index + 1, dp);//not included
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            len = Math.max(len, 1 + helper(nums, n, index, index + 1, dp));//included
        }
        dp[index][prevIndex + 1] = len;
        return len;
    }
    public int LIS(int[] arr,int n){
        int dp[][]=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){//index
            for(int j=i-1;j>=-1;j--) {//prev_index
                int len = dp[i + 1][j + 1];//not include
            if(j==-1||arr[i]>arr[j]){
                len=Math.max(len,1+dp[i+1][j+1]);
            }
            dp[i][j+1]=len;
            }
        }
        return dp[0][0];
    }
    public int Lis(int[] arr,int n){
        int[] dp=new int[n];
        int max=1;
        Arrays.fill(dp,1);
        for(int index=0;index<n;index++){
            for(int prev=0;prev<index;prev++){
                if(arr[prev]<arr[index]){
                    dp[index]=Math.max(dp[index],1+dp[prev]);
                }
            }
            max=Math.max(max,dp[index]);
        }
        return max;
    }
    public int lenOfLIS(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>(nums.length);
        for (int num : nums) {
            if (dp.size() == 0 || dp.get(dp.size()-1) < num) dp.add(num);
            else {
                int i = Collections.binarySearch(dp, num);
                dp.set((i<0) ? -i-1 : i, num);
            }
        }
        return dp.size();
    }
    public static void main(String[] args){
        int[] arr={50,3,10,7,40,80};
        System.out.println(tab(arr));
    }
}
