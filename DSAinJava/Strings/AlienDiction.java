package Strings;
import java.util.*;
public class AlienDiction {
    public static boolean isAlienSorted(String[] words, String order) {
        int n=words.length-1;
        Map<Character,Integer>map=new HashMap<>();
        int weight=1;
        for(char c:order.toCharArray()){
            map.put(c,weight);
            weight++;
        }
        for(int i=0;i<n;i++){
            String first=words[i];
            String second=words[i+1];
            if(!helper(first,second,map)){
                return false;
            }
        }
        return true;
    }
    private static boolean helper(String first,String second,Map<Character,Integer>map){
        int i1=0;
        int i2=0;
        while(i1<first.length()&&i2<second.length()){
            if(first.charAt(i1)!=second.charAt(i2)){
                if(map.get(first.charAt(i1))<map.get(second.charAt(i2))){
                    return true;
                }
                else{
                    return false;
                }
            }
            i1++;
            i2++;
        }
        if(first.length()>second.length()) return false;
        return true;
    }
    public static void main(String[] args){
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean result=isAlienSorted(words,order);
        System.out.println(result);
    }
}
