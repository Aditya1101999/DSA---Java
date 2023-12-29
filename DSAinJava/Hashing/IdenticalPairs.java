package DSAinJava.Hashing;
import java.util.*;
public class IdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int count=0;
        for(int el : nums){
            count+=map.getOrDefault(el,0);
            map.put(el,map.getOrDefault(el,0)+1);
        }
        return count;

    }
}
