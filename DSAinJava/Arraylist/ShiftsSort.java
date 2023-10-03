package DSAinJava.Arraylist;
import java.util.List;
public class ShiftsSort {
    public int minimumRightShifts(List<Integer> nums) {
        int ans=0;
        boolean unsorted=false;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1)>nums.get(i) && !unsorted){
                unsorted=true;
                ans=nums.size()-i;
            }
            else if(nums.get(i-1)>nums.get(i) && unsorted){
                return -1;
            }
        }
        if(ans!=0 && nums.get(nums.size()-1)>nums.get(0)) return -1;
        return ans;
    }
}
