package DSAinJava.Backtracking;
import java.util.*;
public class Permutations {//String
    public static void findPermutations(String str,String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0;i<str.length();i++) {
            char curr=str.charAt(i);
            //"abcde"="ab"+"cd"
            String newStr=str.substring(0,i)+str.substring(i+1);
            findPermutations(newStr, ans + curr);
        }
    }
    public List<List<Integer>> permute(int[] nums) {//approach 1->for distinct elements
        List<List<Integer>>ans=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        findPermutations(nums,ans,visited,new ArrayList<>());
        return ans;
    }
    private void findPermutations(int[] nums,List<List<Integer>>ans,boolean[] visited,ArrayList<Integer>curr){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                curr.add(nums[i]);
                visited[i]=true;
                findPermutations(nums,ans,visited,curr);
                curr.remove(curr.size()-1);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> permuteWithoutVisited(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        findPermutationsSwapping(0,nums,ans);
        return ans;
    }
    private void findPermutationsSwapping(int index,int[] nums,List<List<Integer>>ans){
        if(index==nums.length){//we can use toList function alternatively
            ArrayList<Integer>curr=new ArrayList<>();
            for(int el:nums){
                curr.add(el);
            }
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            findPermutationsSwapping(index+1,nums,ans);//putting every element at each index
            swap(i,index,nums);//backtrack
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        findPermutationsSwapping(0,nums,ans);
        return ans;
    }
    private void findPermutationsSwapping2(int index,int[] nums,List<List<Integer>>ans){
        if(index==nums.length){
            ArrayList<Integer>curr=new ArrayList<>();
            for(int el:nums){
                curr.add(el);
            }
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(i>index && isDuplicate(i,index,nums)) continue;
            swap(i,index,nums);
            findPermutationsSwapping2(index+1,nums,ans);//putting every element at each index
            swap(i,index,nums);//backtrack
        }
    }
    private void swap(int i,int index,int[] nums){
        int temp=nums[i];
        nums[i]=nums[index];
        nums[index]=temp;
    }
    private boolean isDuplicate(int i,int index,int[] nums){
        for(int j=index;j<i;j++){
            if(nums[j]==nums[i]) return true;//appeared before
        }
        return false;
    }
    public static void main(String args[]){
        String str="abc";
        findPermutations(str,"");
    }
}


