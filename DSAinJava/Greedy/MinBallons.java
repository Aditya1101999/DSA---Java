package Greedy;
import java.util.*;
public class MinBallons {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //sorting on the basis of end points(a[1]-b[1] give wrong result beyond a limit)
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int arrow=1;
        int reach=points[0][1];
        for(int i=1;i<points.length;i++){
            if(reach>=points[i][0]){//start point >end->no common area
                continue;
            }
            arrow++;
            reach=points[i][1];
        }
        return arrow;
    }
    public static void main(String[] args){
        int[][] points = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(findMinArrowShots(points));
    }
}
