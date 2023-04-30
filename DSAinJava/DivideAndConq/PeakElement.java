package DSAinJava.DivideAndConq;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]<nums[mid+1]){//probable answer could be on right
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}
