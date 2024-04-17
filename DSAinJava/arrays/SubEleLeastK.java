package DSAinJava.arrays;
import java.util.*;
public class SubEleLeastK {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int max=Arrays.stream(nums).max().orElse(0);
        long ans=0;
        //approach 1-> sliding window
        // int left=0;
        // int right=0;
        // int count=0;
        // while(right<n){
        //     if(nums[right]==max) count++;
        //     while(count==k){
        //         ans+=n-right;
        //         if(nums[left]==max) count--;
        //         left++;
        //     }
        //     right++;
        // }
        //approach 2-> keep track of indices
        List<Integer>indices=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]==max) indices.add(i);
            int size=indices.size();
            if(size>=k){
                ans+=indices.get(size-k)+1;
            }
        }
        return ans;
    }
}
