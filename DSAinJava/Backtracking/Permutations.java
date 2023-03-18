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
    public static void main(String args[]){
        String str="abc";
        findPermutations(str,"");
    }
}


