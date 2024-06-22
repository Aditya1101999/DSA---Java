package DSAinJava.DynProg;
import java.util.Arrays;
public class MaxTotReward {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int max=Arrays.stream(rewardValues).max().orElse(0);
        int n=rewardValues.length;
        int[][] dp=new int[n][max*2];//if we take the max element , the reward can be till max-1 , so total reward<=max*max-1
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solve(rewardValues,0,0,dp);
    }
    private int solve(int[] rewardValues,int index,int reward,int[][] dp){
        if(index==rewardValues.length) return reward;
        if(dp[index][reward]!=-1) return dp[index][reward];
        int take=0;
        if(rewardValues[index]>reward){
            take=solve(rewardValues,index+1,reward+rewardValues[index],dp);
        }
        int notTake=solve(rewardValues,index+1,reward,dp);
        return dp[index][reward]=Math.max(take,notTake);
    }
}
