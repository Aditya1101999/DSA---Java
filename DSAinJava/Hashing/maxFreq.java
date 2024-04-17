package DSAinJava.Hashing;
import java.util.*;
public class maxFreq {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int maxFrequency=0;
        int ans=0;
        for(int el : nums){
            map.put(el,map.getOrDefault(el,0)+1);
            int frequency=map.get(el);
            if(frequency>maxFrequency){
                maxFrequency=frequency;
                ans=frequency;
            }
            else if(frequency==maxFrequency){
                ans+=frequency;
            }
        }
        return ans;
    }
}
