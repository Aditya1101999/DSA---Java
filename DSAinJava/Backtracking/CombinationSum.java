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
}
