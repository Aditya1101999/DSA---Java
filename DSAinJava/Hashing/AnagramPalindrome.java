package Hashing;
import java.util.*;
public class AnagramPalindrome {
    int isPossible (String S)
    {
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
        }
        int count=0;
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            int freq=entry.getValue();
            if(freq%2!=0) count++;
        }
        if(count<=1) return 1;
        else return 0;
    }
}
