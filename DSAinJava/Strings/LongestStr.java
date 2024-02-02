package DSAinJava.Strings;
import java.util.*;
public class LongestStr {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans="";
        for(String word : dictionary){
            if(isSubseq(s,word)){
                if(word.length()>ans.length() || word.length()==ans.length() && word.compareTo(ans)<0){
                    ans=word;
                }
            }
        }
        return ans;
    }
    private boolean isSubseq(String s,String word){
        int j=0;
        for(int i=0;i<s.length();i++){
            if(j<word.length() && s.charAt(i)==word.charAt(j)){
                j++;
            }
        }
        return j==word.length();
    }
}
