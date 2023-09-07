package Hashing;
import java.util.*;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
                return result;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
    public int countPairs(List<Integer> nums, int target) {
        int count=0;
        Collections.sort(nums);
        int i=0;
        int j=nums.size()-1;
        while(i<j){
            if(nums.get(i)+nums.get(j)<target){
                count+=j-i;//no. of pairs
                i++;
            }
            else{
                j--;
            }

        }
        return count;
    }
    public static void main(String[] args){
        int[]  nums = {2,7,11,15};
        int target = 9;
        int[] ans=twoSum(nums,target);
        System.out.println(ans[0]+","+ans[1]);
    }
}
