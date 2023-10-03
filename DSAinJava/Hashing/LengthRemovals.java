package DSAinJava.Hashing;
import java.util.*;
public class LengthRemovals {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int maxFreq=0;
        for(int el : nums){
            map.put(el,map.getOrDefault(el,0)+1);
            maxFreq=Math.max(maxFreq,map.get(el));
        }
        if(maxFreq>nums.size()/2){
            return maxFreq*2-nums.size();
        }
        return nums.size()%2==0 ? 0 : 1;
    }
}
