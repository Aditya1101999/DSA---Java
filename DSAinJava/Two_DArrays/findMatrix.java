package DSAinJava.Two_DArrays;
import java.util.*;
public class findMatrix {
    public List<List<Integer>> find(int[] nums) {
        int n=nums.length;
        int[] map=new int[n+1];
        List<List<Integer>>ans=new ArrayList<>();
        for(int el : nums){
            int freq=map[el];
            if(freq==ans.size()){
                ans.add(new ArrayList<>());
            }
            ans.get(freq).add(el);
            map[el]++;
        }
        return ans;
    }
}
