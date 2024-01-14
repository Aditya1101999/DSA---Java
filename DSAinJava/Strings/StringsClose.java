package DSAinJava.Strings;
import java.util.*;
public class StringsClose {
    public boolean closeStrings(String word1, String word2) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];

        boolean[] isPresent1=new boolean[26];
        boolean[] isPresent2=new boolean[26];

        for(char c:word1.toCharArray()){
            freq1[c-'a']++;
            isPresent1[c-'a']=true;
        }
        for(char c:word2.toCharArray()){
            freq2[c-'a']++;
            isPresent2[c-'a']=true;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1,freq2) && Arrays.equals(isPresent1,isPresent2);
    }
}
