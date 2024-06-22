package DSAinJava.Strings;
import java.util.*;
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int oddFreq=0;
        int n=s.length();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)%2!=0) oddFreq++;
            else oddFreq--;
        }
        return oddFreq>0 ? n-oddFreq+1 : n;
    }
}
