package DSAinJava.DynProg;
import java.util.Arrays;
public class MaxJumps {
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=0;i<nums.
                length;i++){
            for(int j=0;j<i;j++){
                if(Math.abs(nums[i]-nums[j])<=target && dp[j]!=-1){//jump possible from j to i
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }
}
