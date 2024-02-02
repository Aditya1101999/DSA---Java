package DSAinJava.DivideAndConq;

public class PeakElement {
     public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        int low=1;
        int high=nums.length-2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    public int findInMountainArray(int target, int[] mountainArr) {
        int n=mountainArr.length;
        int peak=findPeakElement(mountainArr);
        int low=0;
        int high=peak;
        while(low<=high){//increasing part
            int mid=low+(high-low)/2;
            int midValue=mountainArr[mid];
            if(midValue==target){
                return mid;
            }
            else if(midValue<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        low=peak;
        high=n-1;
        while(low<=high){//decreasing part
            int mid=low+(high-low)/2;
            int midValue=mountainArr[mid];
            if(midValue==target){
                return mid;
            }
            else if(midValue>target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}
