package arrays;
import java.util.*;
public class MaxPoints {
    public static int maxPoints(int[][] points) {
        int n=points.length;
        if(n==0){
            return 0;
        }
        if(n<=2){
            return n;
        }
        int max=0;
        for(int[] point1:points){
            //Slope , No. of points having the same slope value passing through P1
            Map<Double,Integer> map=new HashMap<>();
            for(int[] point2:points){
                if(point1==point2){
                    continue;
                }
                double slope=0;
                if(point2[0]==point1[0]){//x2-x1=0->slope is infinite
                    slope=Double.MAX_VALUE;
                }
                else{//(y2-y1)/(x2-x1)
                    slope=(point2[1]-point1[1])/(double)(point2[0]-point1[0]);//2 points at a time
                }
                map.put(slope,map.getOrDefault(slope,0)+1);
                max=Math.max(max,map.get(slope));
            }
        }
        return max+1;//1 added for the base point
    }
    public static void main(String[] args){
        int[][] points ={{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(points));
    }
}
