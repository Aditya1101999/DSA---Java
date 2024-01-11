package DSAinJava.Hashing;
import java.util.*;
public class LargestSubs {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int max=-1;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(map.containsKey(curr)){
                max=Math.max(max,i-map.get(curr)-1);//excluding the two characters
            }
            else{
                map.put(curr,i);
            }
        }
        return max;
    }
}
