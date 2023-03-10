package DynProg;
import java.util.*;
public class RussianDolls {
    public static int maxEnvelopes(int[][] envelopes) {
        int max=1;
        Arrays.sort(envelopes,(a,b)->(a[0]-b[0]));
        int len=envelopes.length;
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0]//checking height
                        &&envelopes[i][1]>envelopes[j][1]){//checking width
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] nums = {{2, 1}, {1, 5}, {6, 2}, {3, 1}};
        System.out.println(maxEnvelopes(nums));
    }
}
