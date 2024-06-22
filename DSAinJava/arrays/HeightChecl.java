package DSAinJava.arrays;
import java.util.Arrays;
public class HeightChecl {
    public int heightChecker(int[] heights) {
        int max=Arrays.stream(heights).max().orElse(0);
        int[] heightFreq=new int[max+1];
        for(int height : heights) heightFreq[height]++;
        int index=0;
        int ans=0;
        for (int height : heights) {
            while (heightFreq[index] == 0) index++;
            if (height != index) ans++;
            heightFreq[index]--;
        }
        return ans;
    }
}
