package DSAinJava.Greedy;
import java.util.*;
public class WeakCharacters {
    public int numberOfWeakCharacters(int[][] properties) {
        int n=properties.length;
        //increasing attack and decreasing defense
        Arrays.sort(properties,(a,b)->a[0]-b[0]==0 ? b[1]-a[1] : a[0]-b[0]);
        int weak=0;
        int maxDefense=-1;
        for(int i=n-1;i>=0;i--){
            if(properties[i][1]<maxDefense) weak++;

            maxDefense=Math.max(maxDefense,properties[i][1]);
        }
        return weak;
    }
}
