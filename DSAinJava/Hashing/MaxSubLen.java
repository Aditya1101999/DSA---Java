package DSAinJava.Hashing;
import java.util.*;
public class MaxSubLen {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        int left=0;
        int right=0;
        int max=0;
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right])>k){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
