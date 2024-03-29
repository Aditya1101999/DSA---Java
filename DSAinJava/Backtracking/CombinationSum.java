package DSAinJava.Backtracking;
import java.util.*;
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    private void findCombinations(int index,int[] candidates,int target,List<List<Integer>>ans,ArrayList<Integer>curr){
        if(index==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if(candidates[index]<=target){
            curr.add(candidates[index]);
            findCombinations(index,candidates,target-candidates[index],ans,curr);
            curr.remove(curr.size()-1);
        }
        findCombinations(index+1,candidates,target,ans,curr);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {//no duplicates
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(candidates);
        findCombination2(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    private void findCombination2(int index,int[] candidates,int target,List<List<Integer>>ans,ArrayList<Integer>curr){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<candidates.length;i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;

            curr.add(candidates[i]);
            findCombination2(i + 1, candidates, target - candidates[i], ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans=new ArrayList<>();
        solve(1,k,n,ans,new ArrayList<>());
        return ans;
    }
    private void solve(int i,int k,int target,List<List<Integer>>ans,List<Integer>curr){
        if(i==10){
            if(target==0 && curr.size()==k){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if(i<=target){
            curr.add(i);
            solve(i+1,k,target-i,ans,curr);
            curr.remove(curr.size()-1);
        }
        solve(i+1,k,target,ans,curr);
    }
}
