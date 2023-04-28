package DSAinJava.Hashing;
import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        if(n==0) return new ArrayList<>();
        Map<String,List<String>>map=new HashMap<>();
        for(String s:strs){
            String key=getKey(s);
            List<String>list=map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList(map.values());
    }
    private String getKey(String s){
        char[] key=new char[26];
        for(char c:s.toCharArray()){
            key[c-'a']++;
        }
        return new String(key);
    }
}
