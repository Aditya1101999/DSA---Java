package DSAinJava.arrays;
import java.util.*;
public class ContiugousArr {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        //step 1->replacing all zeros by -1;
        // for(int i=0;i<n;i++){
        //     if(nums[i]==0) nums[i]=-1;
        // }
        //step 2->calculating prefix sum
        Map<Integer,Integer>map=new HashMap<>();//<Prefixsum,Index>
        map.put(0,-1);//default case
        int prefixSum=0;
        int ans=0;
        //step 3->checking if prefixSum is already present in map , i.e. that part can be an answer
        for(int i=0;i<n;i++){
            prefixSum+=nums[i]==1 ? 1 : -1;
            if(map.containsKey(prefixSum)){
                ans=Math.max(ans,i-map.get(prefixSum));
            }
            else{
                map.put(prefixSum,i);
            }
        }
        return ans;
    }
}
