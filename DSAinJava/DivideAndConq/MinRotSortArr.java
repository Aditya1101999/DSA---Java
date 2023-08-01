package DSAinJava.DivideAndConq;

public class MinRotSortArr {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high]){//complete search space is sorteed
                ans=Math.min(ans,nums[low]);
                break;
            }
            if(nums[high]>=nums[mid]){//right part is sorted
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
            else{
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
        }
        return ans;//this element index will tell us how many times the array is rotated
    }
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[low] == nums[mid]) {
                ans=Math.min(ans,nums[low]);
                low++;
            } else if (nums[high] >= nums[mid]) {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            } else {
                ans=Math.min(ans,nums[low]);
                low = mid + 1;
            }
        }
        return ans;
    }
}
