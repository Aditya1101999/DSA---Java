package DSAinJava.Strings;
import java.util.*;
public class CommonCharacters {
    public List<String> commonChars(String[] words) {
        int[] freq=frequency(words[0]);
        for(int i=1;i<words.length;i++){
            String word=words[i];
            int[] temp=frequency(word);
            for(int j=0;j<26;j++){
                freq[j]=Math.min(freq[j],temp[j]);
            }
        }
        List<String>ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            int charFreq=freq[i];
            while(charFreq-->0){
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
    private int[] frequency(String word){
        int[] freq=new int[26];
        for(char c : word.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}
