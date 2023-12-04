package DSAinJava.Greedy;
import java.util.*;
public class MaxSpending {
    public long maxSpending(int[][] values) {
        List<Integer>items=new ArrayList<>();
        for(int[] row : values){
            for(int val : row){
                items.add(val);
            }
        }
        Collections.sort(items);
        long ans=0;
        long days=1;
        for(int el : items){
            ans+=days*el;
            days++;
        }
        return ans;
    }
}
