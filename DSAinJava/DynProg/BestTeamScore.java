package DynProg;
import java.util.Arrays;
public class BestTeamScore {
    public static int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        int[][] team=new int[n][2];
        int max=0;
        for(int i=0;i<n;i++){
            team[i][0]=ages[i];
            team[i][1]=scores[i];
        }
        Arrays.sort(team,(a,b)->(a[0]-b[0]==0)?a[1]-b[1]:a[0]-b[0]);
        int[] dp=new int[n];
        dp[0]=team[0][1];
        for(int i=1;i<n;i++){
            dp[i]=team[i][1];
            for(int j=0;j<i;j++){
                if(team[i][1]>=team[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+team[i][1]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        for(int el:dp){
            max=Math.max(max,el);
        }
        return max;
    }
}
