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
    public int maxEnvelopesBinarySearch(int[][] envelopes) {
        //increasing width and decreasing heights(as we want strictly increasing dimensions only)
        Arrays.sort(envelopes,(a,b)->a[0]-b[0]==0 ? b[1]-a[1] : a[0]-b[0]);
        int[] dp=new int[envelopes.length+1];//heights
        Arrays.fill(dp,Integer.MAX_VALUE);
        int ans=0;
        for(int i=0;i<envelopes.length;i++){
            int insertionPoint=Arrays.binarySearch(dp,envelopes[i][1]);
            insertionPoint=insertionPoint<0 ? -(insertionPoint+1) : insertionPoint;
            dp[insertionPoint]=envelopes[i][1];
            //since insertionPoint represents an index , so adding 1
            ans=Math.max(ans,insertionPoint+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] nums = {{2, 1}, {1, 5}, {6, 2}, {3, 1}};
        System.out.println(maxEnvelopes(nums));
    }
}
