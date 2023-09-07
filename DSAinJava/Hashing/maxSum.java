package DSAinJava.Hashing;
import java.util.*;
public class maxSum {
    public long maximumSum(List<Integer> nums, int m, int k) {
        long maxSum=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.size();i++){
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
            if(i>=k){
                map.put(nums.get(i-k),map.getOrDefault(nums.get(i-k),0)-1);
                if(map.get(nums.get(i-k))==0) map.remove(nums.get(i-k));
            }
            if(i>=k-1 && map.size()>=m){//answers possible
                long sum=0;
                for(int j=i-k+1;j<=i;j++){
                    sum+=(long)nums.get(j);
                }
                maxSum=Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }
}
