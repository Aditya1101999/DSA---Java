package DSAinJava.arrays;
import java.util.*;
public class SubarraySumK {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer>list=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();//currSum,index
        int currSum=0;
        int start=0;
        int end=-1;
        for(int i=0;i<n;i++){
            currSum+=arr[i];
            if(currSum==s){
                end=i;
                break;
            }
            if(map.containsKey(currSum-s)){//subarray found
                start=map.get(currSum-s)+1;
                end=i;
                break;
            }
            map.put(currSum,i);
        }
        if(end==-1) list.add(-1);
        else{
            list.add(start+1);
            list.add(end+1);
        }
        return list;
    }
    public int subarraySum(int[] nums, int k) {//count no. of subarrays
        int n=nums.length;
        int prefixSum=0;
        int ans=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);//<prefixSum,frequency of the sum>
        for(int i=0;i<n;i++){
            prefixSum+=nums[i];
            if(map.containsKey(prefixSum-k)){
                ans+=map.get(prefixSum-k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return ans;
    }
    static ArrayList<Integer> subarraySum2(int[] arr, int n, int s) {
        int i=0;
        int j=0;
        int currSum=arr[0];
        ArrayList<Integer>list=new ArrayList<>();
        if(s==0){
            list.add(-1);
            return list;
        }
        while(j<n){
            if(currSum==s){
                list.add(i+1);
                list.add(j+1);
                return list;
            }
            else if(currSum<s){
                j++;
                if(j>=n) break;
                currSum+=arr[j];
            }
            else{
                currSum-=arr[i];
                i++;
            }
        }
        list.add(-1);
        return list;
    }
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target = sum - x;
        int left = 0;
        int right = 0;
        int currSum = 0;
        int min = n;

        while (right < n) {
            currSum += nums[right];
            while (currSum > target && left <= right) {
                currSum -= nums[left];
                left++;
            }

            if (currSum == target) {
                min = Math.min(min, n - (right - left + 1)); // Update min when currSum == target
            }

            right++;
        }

        return min == n ? -1 : min; // Return -1 if no valid subarray is found, otherwise return min.
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>=target && left<=right){
                ans=Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args){
        int N = 5, S = 12;
        int A[] = {1,2,3,7,5};
        System.out.println(subarraySum(A,N,S));
        System.out.println(subarraySum2(A,N,S));
    }
}
