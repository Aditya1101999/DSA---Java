package DSAinJava.arrays;
import java.util.*;
public class canSplitArray {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if(nums.size()<3) return true;
        if(nums.get(0)+nums.get(1)>=m) return true;
        for(int i=1;i<nums.size();i++){//we need just one possible pair
            if(nums.get(i-1)+nums.get(i)>=m){
                return true;
            }
        }
        return false;
    }
}
