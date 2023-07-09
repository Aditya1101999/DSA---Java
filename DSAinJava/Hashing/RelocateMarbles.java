package DSAinJava.Hashing;
import java.util.*;
public class RelocateMarbles {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer>set=new TreeSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int i=0;i<moveFrom.length;i++){
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        return new ArrayList<>(set);
    }
}
