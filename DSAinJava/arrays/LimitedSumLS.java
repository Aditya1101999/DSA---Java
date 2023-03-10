package arrays;
import java.util.*;
public class LimitedSumLS {
    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {//making prefix sum array
            nums[i] += nums[i - 1];
        }
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(nums, queries[i]);
            //j is the index at which queries[i] is found. j+1 will be the length of subsequence. if queries[i] is not found, it will return -(j+1). hence Math.abs
            ans[i] = Math.abs(j + 1);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        int[] ans=answerQueries(nums,queries);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
