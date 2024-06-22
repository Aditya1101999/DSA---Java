package DSAinJava.arrays;

public class SubsetXor {
    public int subsetXORSum(int[] nums) {
        int ans=0;
        for(int num : nums){
            ans|=num;
        }
        return ans<<(nums.length-1);
    }
}
