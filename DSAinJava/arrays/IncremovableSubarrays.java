package DSAinJava.arrays;

public class IncremovableSubarrays {
    public int incremovableSubarrayCount(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){//removing the subarray from i to j
                if(isIncreasing(nums,i,j)) count++;
            }
        }
        return count;
    }
    private boolean isIncreasing(int[] nums,int start,int end){
        int n=nums.length;
        int prev=0;
        for(int i=0;i<n;i++){
            if(i>=start && i<=end) continue;

            if(nums[i]<=prev) return false;

            prev=nums[i];
        }
        return true;
    }
}
