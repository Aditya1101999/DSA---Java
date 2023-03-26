package DynProg;
import java.util.*;
public class MinJumps {//tell whether jumps possible
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int max=nums[0];
        for(int i=1;i<=max;i++){
            if(max>=nums.length-1){
                return true;
            }
            max=Math.max(max,nums[i]+i);//max jumps
        }
        return false;
    }
    //tells no. of jumps
    public static int tab(int[] arr){//brute
        int n= arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        //initialization
        dp[n-1]=0;//0 jumps
        for(int i=n-2;i>=0;i--){
            int steps=arr[i];
            int ans=Integer.MAX_VALUE;
            for(int j=i+1;j<=i+steps&&j<n;j++){//distance that can be covered
                if(dp[j]!=-1){
                    ans=Math.min(ans,dp[j]+1);
                }
            }
            if(ans!=Integer.MAX_VALUE){
                dp[i]=ans;
            }
        }
        return dp[0];
    }
    public int jump(int[] nums) {//optimal
        int jumps=0;
        int maxReachIndex=0;
        int divider=0;
        for(int i=0;i<nums.length;i++){
            if(i>divider){
                jumps++;
                divider=maxReachIndex;
            }
            maxReachIndex=Math.max(maxReachIndex,i+nums[i]);
            if (maxReachIndex <= i) {
                return -1; // can't reach last index
            }
        }
        return jumps;
    }
    public static void main(String[] args){
        int[] nums={2,3,1,1,4};
        System.out.println(tab(nums));
    }
}
