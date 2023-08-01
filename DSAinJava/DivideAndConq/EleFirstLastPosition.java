package DSAinJava.DivideAndConq;

public class EleFirstLastPosition {
    private int firstOccurance(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return ans;
    }
    private int lastOccurance(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }
            else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return ans;
    }
    public int[] searchRange2(int[] nums, int target) {
        int first=firstOccurance(nums,target);
        if(first==-1) return new int[]{-1,-1};
        int last=lastOccurance(nums,target);
        //last-first+1 gives no. of occurances
        return new int[]{first,last};
    }
}
