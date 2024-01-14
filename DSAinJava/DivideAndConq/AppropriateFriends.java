package DSAinJava.DivideAndConq;
import java.util.Arrays;
public class AppropriateFriends {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans=0;
        //age[x]>=age[y]>age[x]/2+7
        for(int age : ages){
            //first occurance where the el is greater than age/2+7
            int low=firstOccurance(ages,age/2+7);
            int high=firstOccurance(ages,age);
            //subtract this element (can't send request to himself)
            ans+=Math.max(0,high-low-1);//age[x] could be less than age[x]/2+7
        }
        return ans;
    }
    private int firstOccurance(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
}
