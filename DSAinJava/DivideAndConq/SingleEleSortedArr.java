package DSAinJava.DivideAndConq;

public class SingleEleSortedArr {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=(low+high)/2;
            if((mid%2==0 && nums[mid]==nums[mid+1]) ||
                    (mid%2!=0 && nums[mid]==nums[mid-1])) low=mid+1;
            else high=mid;//the element lies in the left part
        }
        return nums[low];
    }
}
