package DSAinJava.DynProg;

public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int n=boxes.length;
        int[][][] dp=new int[n][n][n];
        return removeHelper(boxes,0,n-1,0,dp);
    }
    private int removeHelper(int[] boxes,int i,int j,int streak, int[][][] dp){
        if(i>j) return 0;
        if(i==j){
            return (streak+1)*(streak+1);
        }
        if(dp[i][j][streak]!=0) return dp[i][j][streak];
        //streak reset
        int maxStreak=(streak+1)*(streak+1)+removeHelper(boxes,i+1,j,0,dp);
        for(int k=i+1;k<=j;k++){
            if(boxes[i]==boxes[k]){//subarray between the equal elements(streak will be new for that)+rest of the array(streak will be continued with +1 as one character was same )
                maxStreak=Math.max(maxStreak,
                        removeHelper(boxes,i+1,k-1,0,dp)+removeHelper(boxes,k,j,streak+1,dp));
            }
        }
        return dp[i][j][streak]=maxStreak;
    }
}
