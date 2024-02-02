package DSAinJava.Hashing;
import java.util.*;
public class UniqueOccurances {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int el : arr){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        Set<Integer>occurances=new HashSet<>(map.values());
        return map.size()==occurances.size();
    }
}
