package DSAinJava.arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int el:nums){
            sum+=el;
        }
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            if(sum-prefixSum-nums[i]==prefixSum) return i;//nums[i] is pivot
            prefixSum+=nums[i];
        }
        return -1;
    }
}
