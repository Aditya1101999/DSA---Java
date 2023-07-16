package DSAinJava.Strings;
import java.util.*;
public class PrefixPresentStrings {
    public static String longestString(int n, String[] arr) {
        String longest="";
        Set<String>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        for(String word:arr){//greater than , and if equal than lexographically smaller
            if(word.length()>longest.length()||(word.length()==longest.length() && word.compareTo(longest)<0)){
                boolean valid=true;
                for(int i=1;i<word.length();i++){
                    String prefix=word.substring(0,i);
                    if(!set.contains(prefix)){
                        valid=false;
                        break;
                    }
                }
                if(valid) longest=word;
            }
        }
        return longest;
    }
}
