package DSAinJava.Hashing;
import java.util.*;
public class WordsAddingLetter {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer>set=new HashSet<>();
        for(String start : startWords){
            set.add(bitmask(start));
        }
        int ans=0;
        for(String word : targetWords){
            int mask=bitmask(word);
            for(char c : word.toCharArray()){
                if(set.contains(mask-(1<<c-'a'))){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
    private int bitmask(String word){
        int ans=0;
        for(char c : word.toCharArray()){
            ans  = ans | (1<<c-'a');
        }
        return ans;
    }
}
