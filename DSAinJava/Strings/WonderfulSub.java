package DSAinJava.Strings;
import java.util.*;
public class WonderfulSub {
    public long wonderfulSubstrings(String word) {
        long ans=0;
        int mask=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(char c : word.toCharArray()){
            int character=c-'a';
            mask^=(1<<character);
            if(map.containsKey(mask)){//no odd letter
                ans+=map.get(mask);
            }
            map.put(mask,map.getOrDefault(mask,0)+1);
            for(int i=0;i<10;i++){//at most one letter
                int character1=(1<<i);
                if(map.containsKey(mask^character1)){
                    ans+=map.get(mask^character1);
                }
            }
        }
        return ans;
    }
}
