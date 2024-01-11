package DSAinJava.Hashing;
import java.util.*;
public class RandomPointRectangeles {
    private TreeMap<Integer,Integer>map;
    private int sum;
    private int[][] rects;
    private Random rand;
    public RandomPointRectangeles(int[][] rects) {
        map=new TreeMap<>();
        sum=0;
        this.rects=rects;
        rand=new Random();
        for(int i=0;i<rects.length;i++){
            int[] rect=rects[i];
            sum+=(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);//cumulative area(inclusive)
            map.put(sum,i);
        }
    }

    public int[] pick() {
        //+1 is added as upper bound is exclusive in random functions
        int num=map.ceilingKey(rand.nextInt(sum)+1);
        int[] rect=rects[map.get(num)];
        //adding rect[0] and rect[1] to shift lower bound from 0
        return new int[]{rect[0]+rand.nextInt(rect[2]-rect[0]+1),rect[1]+rand.nextInt(rect[3]-rect[1]+1)};
    }
}
