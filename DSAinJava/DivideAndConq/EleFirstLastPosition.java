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
