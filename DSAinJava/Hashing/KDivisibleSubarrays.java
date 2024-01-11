package DSAinJava.Hashing;
import java.util.*;
public class KDivisibleSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        int n=nums.length;
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<n;i++){
            int count=0;
            List<Integer>temp=new ArrayList<>();
            for(int j=i;j<n;j++){//for each subarray starting with this i
                temp.add(nums[j]);
                if(nums[j]%p==0) count++;
                if(count<=k){
                    set.add(new ArrayList<>(temp));
                }
                else break;
            }
        }
        return set.size();
    }

}
