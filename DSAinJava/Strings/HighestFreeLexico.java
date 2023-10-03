package DSAinJava.Strings;
import java.util.*;
public class HighestFreeLexico {
    public static String solve(int n, String s) {
        Map<Character,Integer>map=new HashMap<>();
        char[] characters=s.toCharArray();
        char ans=characters[0];
        int maxFreq=1;
        for(char c:characters){
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)>maxFreq || (map.get(c)==maxFreq && c<ans)){
                ans=c;
                maxFreq=map.get(c);
            }
        }
        return Character.toString(ans);
    }
}
