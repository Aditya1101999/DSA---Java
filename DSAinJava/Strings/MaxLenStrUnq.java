package DSAinJava.Strings;
import java.util.*;
public class MaxLenStrUnq {
    static int ans;
    public int maxLength(List<String> arr) {
        ans=0;
        List<Integer>unique=new ArrayList<>();
        for(String str : arr){
            Set<Character>set=new HashSet<>();
            int mask=0;
            for(char c : str.toCharArray()){
                set.add(c);
                mask = mask | (1 << (c - 'a'));

            }
            if(set.size()==str.length()){
                unique.add(mask);
            }
        }
        solve(0,0,unique);
        return ans;
    }
    private void solve(int index,int mask,List<Integer>unique){
        if(index==unique.size()){
            ans=Math.max(ans,Integer.bitCount(mask));
            return;
        }
        if((mask & unique.get(index))==0)
            solve(index + 1, mask | unique.get(index), unique);
        solve(index + 1, mask, unique);
    }
}
