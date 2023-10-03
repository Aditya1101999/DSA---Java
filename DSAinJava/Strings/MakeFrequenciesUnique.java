package DSAinJava.Strings;
import java.util.*;
public class MakeFrequenciesUnique {
    public int minDeletions(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            freq[curr-'a']++;
        }
        int deletions=0;
        Set<Integer>set=new HashSet<>();
        for(int count : freq){
            while(count>0 && set.contains(count)){
                count--;
                deletions++;
            }
            set.add(count);
        }
        return deletions;
    }

}
