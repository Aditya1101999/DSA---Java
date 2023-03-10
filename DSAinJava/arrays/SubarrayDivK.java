package arrays;
import java.util.*;
public class SubarrayDivK {
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();//remainder,freq
        map.put(0,1);//default case
        int count=0;
        int runningSum=0;
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            int remainder=runningSum%k;
            if(remainder<0){
                remainder+=k;
            }
            if(map.containsKey(remainder)){
                count+=map.get(remainder);
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums={4,5,0,-2,-3,1};
        int k= 5;
        System.out.println(subarraysDivByK(nums,k));
    }
}
