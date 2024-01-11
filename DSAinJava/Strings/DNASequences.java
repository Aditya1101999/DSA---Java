package DSAinJava.Strings;
import java.util.*;
public class DNASequences {
    //brute force will be to generate all substrings of length 10 , store in map , and return having
    //frequency more than 1
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String>set=new HashSet<>() , repeated=new HashSet<>();
        for(int i=0;i<s.length()-9;i++){
            String substr=s.substring(i,i+10);
            if(set.contains(substr)){
                repeated.add(substr);
            }
            else set.add(substr);
        }
        return new ArrayList<>(repeated);
    }
}
