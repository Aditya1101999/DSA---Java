package DSAinJava.Two_DArrays;
import java.util.*;
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result=new ArrayList<>();
        int i=0;
        while(i<intervals.length){
            if(intervals[i][1]<newInterval[0]){
                result.add(intervals[i]);
            }
            else if(intervals[i][0]>newInterval[1]){
                break;
            }
            else{//overlapping case
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
            i++;
        }
        result.add(newInterval);
        while(i<intervals.length){
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][2]);
    }
}
