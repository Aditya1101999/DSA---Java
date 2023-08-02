package DSAinJava.DivideAndConq;

public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        //n is the minimum sum we can have by keeping divisor as max element of arr
        if(nums.length>threshold) return -1;//not possible as we can't reduce the sum further
        int max=Integer.MIN_VALUE;
        for(int el:nums){
            max=Math.max(max,el);
        }
        int low=1;
        int high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(nums,mid,threshold)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean isPossible(int[] nums,int divisor,int threshold){
        int sum=0;
        for(int el:nums){
            sum+=Math.ceil((double)el/(double)divisor);
        }
        return sum<=threshold;
    }
}
