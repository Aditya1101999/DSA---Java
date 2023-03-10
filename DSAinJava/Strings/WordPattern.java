package Strings;
import java.util.*;
public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String>map=new HashMap<>();
        Set<String>set=new HashSet<>();
        String[] str=s.split(" ");
        if(str.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            Character key=pattern.charAt(i);
            String curr=str[i];
            if(map.containsKey(key)){//old pair
                String existing=map.get(key);
                if(!curr.equals(existing)){
                    return false;
                }
            }
            else{//new pair
                if(set.contains(curr)){
                    return false;
                }
                else{
                    set.add(curr);
                    map.put(key,curr);
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern,s));
    }

}
