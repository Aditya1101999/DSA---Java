package DSAinJava.Backtracking;
import java.util.*;
public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        findCombinations(1,n,k,ans,new ArrayList<>());
        return ans;
    }
    private static void findCombinations(int index,int n,int k,List<List<Integer>>ans,ArrayList<Integer>curr){
        if(k==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<=n;i++) {//1-based indexing
            curr.add(i);
            findCombinations(i + 1, n, k - 1, ans, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k=2;
        int n=4;
        System.out.println(combine(n,k));
    }
}
