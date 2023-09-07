package DSAinJava.Strings;
import java.util.*;
public class CanBeEqual {
    public boolean canBeEqual(String s1, String s2) {
        char[] cArray=s1.toCharArray();
        for(int i=0;i<cArray.length-2;i++){
            if(cArray[i]!=s2.charAt(i)){
                swap(cArray,i,i+2);
            }
        }
        s1=new String(cArray);
        return s1.equals(s2);
    }
    private void swap(char[] cArray,int i,int j){
        char temp=cArray[i];
        cArray[i]=cArray[j];
        cArray[j]=temp;
    }
    public boolean checkStrings(String s1, String s2) {
        Map<Character,Integer>odd=new HashMap<>();
        Map<Character,Integer>even=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            if(i%2==0) even.put(c,even.getOrDefault(c,0)+1);
            else odd.put(c,odd.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s2.length();i++){
            char c=s2.charAt(i);
            if(i%2==0){
                if(even.containsKey(c)){
                    int freq=even.get(c);
                    freq--;
                    if(freq==0) even.remove(c);
                    else even.put(c,freq);
                }
                else{
                    return false;
                }
            }
            else{
                if(odd.containsKey(c)){
                    int freq=odd.get(c);
                    freq--;
                    if(freq==0) odd.remove(c);
                    else odd.put(c,freq);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
