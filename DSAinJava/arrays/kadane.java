package arrays;
public class kadane {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum<0) sum = 0;
        }
        System.out.println("maximum sum is" + max);
        return max;

    }
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0;
        int maxSum=nums[0];
        int currMax=0;
        int minSum=nums[0];
        int currMin=0;
        for(int el:nums){
            currMax=Math.max(el,el+currMax);
            maxSum=Math.max(currMax,maxSum);

            currMin=Math.min(el,el+currMin);
            minSum=Math.min(currMin,minSum);

            totalSum+=el;
        }
        return (maxSum>0)?Math.max(maxSum,totalSum-minSum):maxSum;
    }
    public static void main(String args[]){
        int numbers[]={-2,-3,-4,-5};
        maxSubArray(numbers);
    }
}
