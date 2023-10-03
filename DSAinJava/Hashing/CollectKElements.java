package DSAinJava.Hashing;
import java.util.*;
public class CollectKElements {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer>collections=new HashSet<>();
        int count=0;
        for(int i=nums.size()-1;i>=0;i--){
            if(nums.get(i)<=k)collections.add(nums.get(i));
            count++;
            if(collections.size()==k){
                break;
            }
        }
        return count;
    }
}
