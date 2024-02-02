package DSAinJava.DynProg;
import java.util.Arrays;
public class SpecialPermutations {
    public int specialPerm(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][(1<<n)+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,-1,0,0,dp);
    }
    private int solve(int[] nums,int prevIndex,int currIndex,int mask,int[][] dp){
        if(currIndex==nums.length){
            return 1;
        }
        int mod=(int)1e9+7;
        if(dp[prevIndex+1][mask]!=-1){
            return dp[prevIndex+1][mask];
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if((mask & (1<<i))!=0){//ith element has been consumed
                continue;
            }
            if(prevIndex==-1 || nums[i]%nums[prevIndex]==0 || nums[prevIndex]%nums[i]==0){
                ans=(ans+solve(nums,i,currIndex+1,mask | (1<<i),dp))%mod;//ith element consumed
            }
        }
        return dp[prevIndex+1][mask]=ans;//shifting range of prevIndex from -1 to 0
    }
}
