package DSAinJava.Hashing;
import java.util.*;
public class minOperations {
    public int minoperations(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int el : nums){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            if(entry.getValue()==1) return -1;
            else{
                count+=Math.ceil(((double)entry.getValue())/3);
            }
        }
        return count;
    }
}
