package DSAinJava.DynProg;

public class PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        int sum=0;
        int[][][] dp=new int[n][n][2];
        for(int el:nums){
            sum+=el;
        }//0->player 1 turn , 1-> player 2 turn
        int firstPlayerScore=calculateScore(nums,0,n-1,0,dp);
        int secondPlayerScore=sum-firstPlayerScore;
        return firstPlayerScore>=secondPlayerScore;
    }
    private int calculateScore(int[] nums,int i,int j,int turn,int[][][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j][turn]!=0) return dp[i][j][turn];
        if(turn==0){//1st player turn
            return dp[i][j][turn]=Math.max(nums[i]+calculateScore(nums,i+1,j,1,dp),
                    nums[j]+calculateScore(nums,i,j-1,1,dp));
        }
        else{//2nd player turn
            return dp[i][j][turn]=Math.min(calculateScore(nums,i+1,j,0,dp),calculateScore(nums,i,j-1,0,dp));
        }
    }
}
