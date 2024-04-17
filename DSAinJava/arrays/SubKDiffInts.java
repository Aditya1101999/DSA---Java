package DSAinJava.arrays;
import java.util.*;
public class SubKDiffInts {
    public int subarraysWithKDistinct(int[] nums, int k) {
        //approach 1
        // return slidingWindow(nums,k)-slidingWindow(nums,k-1);
        //approach 2->one pass
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        int start=0;
        int left=0;
        int right=0;
        int ans=0;
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;
                start=left;
            }
            while(map.get(nums[left])>1){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            if(map.size()==k) ans+=left-start+1;
            right++;
        }
        return ans;
    }
    private int slidingWindow(int[] nums,int k){
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        int left=0;
        int right=0;
        int ans=0;
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;
            }
            ans+=right-left+1;
            right++;
        }
        return ans;
    }
}
