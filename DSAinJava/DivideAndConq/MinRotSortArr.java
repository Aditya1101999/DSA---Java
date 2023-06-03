package DSAinJava.DivideAndConq;

public class MinRotSortArr {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[high]>=nums[mid]){//right part is sorted
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return nums[low];//low also tells how many times the array is rotated
    }
    public int findMin2(int[] nums) {//contains duplicate elements
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[high]==nums[mid]){
                high=high-1;//to make a decision further
            }
            else if(nums[high]>nums[mid]){//right part is sorted
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return nums[low];
    }
}
