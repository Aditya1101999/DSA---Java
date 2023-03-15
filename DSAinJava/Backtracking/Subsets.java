package DSAinJava.Backtracking;
import java.util.*;
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        if(nums.length==0){
            return ans;
        }
        findSubsets(0,nums,ans,new ArrayList<>());
        return ans;
    }
    private void findSubsets(int index,int[] nums,List<List<Integer>>ans,ArrayList<Integer>curr){
        ans.add(new ArrayList<>(curr));

        for(int i=index;i<nums.length;i++){
            curr.add(nums[i]);
            findSubsets(i+1,nums,ans,curr);
            curr.remove(curr.size()-1);
        }
    }
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer>ans=new ArrayList<>();
        findSubsetsSum(0,0,arr,N,ans);
        Collections.sort(ans);
        return ans;
    }
    private static void findSubsetsSum(int index,int sum,ArrayList<Integer>arr,int N,ArrayList<Integer>ans){
        if(index==N){
            ans.add(sum);
            return;
        }
        findSubsetsSum(index+1,sum+arr.get(index),arr,N,ans);
        findSubsetsSum(index+1,sum,arr,N,ans);
    }
    public static void findSubsets(String str,String ans,int i){
        //base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
                return;
            }else {
                System.out.println(ans);
            }
            return;
        }
        //if string is added(yes)
        findSubsets(str,ans+str.charAt(i),i+1);
        //if not added(no)
        findSubsets(str, ans, i+1);
    }
    public static void main(String args[]){
        String str="abc";
        findSubsets(str,"",0);
    }
}
