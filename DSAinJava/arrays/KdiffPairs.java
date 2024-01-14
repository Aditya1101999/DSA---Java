package DSAinJava.arrays;
import java.util.*;
public class KdiffPairs {
    //n log n
    public int findPairsBinarySearch(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<n-1;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            if(Arrays.binarySearch(nums,i+1,n,nums[i]+k)>0) count++;
        }
        return count;
    }
    public int findPairs(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int el : nums){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        int count=0;
        for(int el : map.keySet()){
            if(k>0 && map.containsKey(el+k) || k==0 && map.get(el)>1) count++;
        }
        return count;
    }
}
