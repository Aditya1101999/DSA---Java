package DSAinJava.Hashing;
import java.util.*;
public class MaxGoodSubSum {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        Map<Integer, Long> map = new HashMap<>();//value , prefixSum
        long max = Long.MIN_VALUE;
        map.put(nums[0],0L);
        for (int i = 1; i < n; i++) {
            if (map.containsKey(nums[i] - k)) {
                long currSum = prefixSum[i] - map.get(nums[i]-k);
                max = Math.max(max, currSum);
            }
            if (map.containsKey(nums[i] + k)) {
                long currSum = prefixSum[i] - map.get(nums[i]+k);
                max = Math.max(max, currSum);
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], prefixSum[i-1]);
            }
            else{
                map.put(nums[i],Math.min(map.get(nums[i]),prefixSum[i-1]));
            }
        }
        return max==Long.MIN_VALUE ? 0 :max;
    }
}
