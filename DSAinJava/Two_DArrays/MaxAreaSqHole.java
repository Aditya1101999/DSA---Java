package DSAinJava.Two_DArrays;
import java.util.Arrays;
public class MaxAreaSqHole {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        //if hBars or vBars would be empty => max area 1
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int count=1;
        int maxHeight=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]==hBars[i-1]+1){
                count++;
            }
            else{
                count=1;
            }
            maxHeight=Math.max(maxHeight,count);
        }
        count=1;
        int maxWidth=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]==vBars[i-1]+1){
                count++;
            }
            else{
                count=1;
            }
            maxWidth=Math.max(maxWidth,count);
        }
        int minDimension=Math.min(maxHeight,maxWidth)+1;
        return minDimension*minDimension;
    }
}
