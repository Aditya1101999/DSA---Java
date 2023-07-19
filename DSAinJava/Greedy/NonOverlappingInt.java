package DSAinJava.Greedy;
import java.util.Arrays;
public class NonOverlappingInt {
    public int eraseOverlapIntervals(int[][] intervals) {//O(n log n)
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int count=0;
        int prevEnd=intervals[0][1];
        for(int i=1;i<n;i++){
            if(prevEnd>intervals[i][0]){//overlapping interval
                count++;
                prevEnd=Math.min(prevEnd,intervals[i][1]);//we want minimum intervals to be removed
            }
            else{
                prevEnd=intervals[i][1];
            }
        }
        return count;
    }
}
