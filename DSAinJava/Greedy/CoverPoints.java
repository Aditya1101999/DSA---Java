package DSAinJava.Greedy;
import java.util.Arrays;
public class CoverPoints {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points,(a,b)->(a[0]-b[0]));
        int ans=1;
        int curr=points[0][0];
        for(int[] point : points){
            if(point[0]>curr+w){
                ans++;
                curr=point[0];
            }
        }
        return ans;
    }
}
