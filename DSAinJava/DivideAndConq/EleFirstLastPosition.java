package DSAinJava.DivideAndConq;

public class EleFirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int[] ans=new int[]{-1,-1};
        if(high<0){
            return ans;
        }
        //find starting index
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        if(nums[low]==target){
            ans[0]=low;
        }
        low=0;
        high=nums.length-1;
        //find ending index
        while(low<high){
            int mid=low+(high-low+1)/2;//we want mid to be inclined towards right
            if(nums[mid]<=target){
                low=mid;
            }
            else{
                high=mid-1;
            }
        }
        if(nums[low]==target){
            ans[1]=low;
        }
        return ans;
    }
}
