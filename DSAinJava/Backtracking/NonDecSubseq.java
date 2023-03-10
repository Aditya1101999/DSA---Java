package Backtracking;
import java.util.*;
public class NonDecSubseq {
    private static Set<List<Integer>>set;
    public static List<List<Integer>> findSubsequences(int[] nums) {
        set=new HashSet<>();
        recursion(nums,0,new ArrayList<>());
        return new ArrayList<>(set);
    }
    private static void recursion(int[] nums,int curr,ArrayList<Integer>currList){
        if(currList.size()>=2){
            set.add(new ArrayList<>(currList));
        }
        for(int i=curr;i<nums.length;i++){//non-decreasing
            if(currList.size()==0||currList.get(currList.size()-1)<=nums[i]){
                currList.add(nums[i]);
                recursion(nums,i+1,currList);
                currList.remove(currList.size()-1);//backtracking
            }
        }
    }
    public static void main(String[] args){
        int[] nums ={4,6,7,7};
        System.out.println(findSubsequences(nums));
    }
}
