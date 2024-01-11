package DSAinJava.Two_DArrays;
import java.util.*;
public class FlipMatrix {
    Map<Integer,Integer>map;
    int m,n,total;
    Random rand;
    public FlipMatrix(int m, int n) {
        map=new HashMap<>();
        this.m=m;
        this.n=n;
        total=m*n;
        rand=new Random();
    }

    public int[] flip() {
        int index=rand.nextInt(total--);
        int actual=map.getOrDefault(index,index);
        //set last value to this index[first reduced , as we following 0 based indexing]
        //i.e. if total=m*n=12 , we will store till 0-11
        map.put(index,map.getOrDefault(total,total));
        return new int[]{actual/n,actual%n};//row,col
    }

    public void reset() {
        total=m*n;
        map.clear();
    }
}
