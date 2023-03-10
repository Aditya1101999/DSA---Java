package Two_DArrays;
import java.util.*;
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<int[]>res=new ArrayList<>();
        if(intervals.length==0){
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int[] i:intervals){//traversing each pair
            if(i[0]<=end){//can be merged
                end=Math.max(end,i[1]);
            }
            else{//non-overlapping pair
                res.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][1]);
    }
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
    }
}
