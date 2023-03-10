package Strings;

import java.util.*;
import java.util.Scanner;

public class Anagrams {
    public static boolean isAnagram(String a,String b)
    {

        // Your code here
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<a.length();i++){
            if(map.containsKey(a.charAt(i))){
                map.put(a.charAt(i),map.get(a.charAt(i))+1);
            }
            else{
                map.put(a.charAt(i),1);
            }
        }
        for(int i=0;i<b.length();i++){
            if(map.containsKey(b.charAt(i))){
                map.put(b.charAt(i),map.get(b.charAt(i))-1);
            }
            else{
                return false;
            }
        }
        Set<Character>set=map.keySet();
        for(char key:set){
            if(map.get(key)!=0){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
        int n=s.length();
        int m=p.length();
        for(int i=0;i<=n-m;i++){//range in which anagrams can lie
            if(issAnagram(p,s.substring(i,i+m))){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean issAnagram(String s1,String s2){
        int[] ch=new int[26];
        for(int i=0;i<s1.length();i++){
            ch[s1.charAt(i)-'a']++;
            ch[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=0) return false;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string 1");
        String str1=sc.next();
        System.out.println("enter strng 2");
        String str2=sc.next();
        //no separate checking for upper and lower cases
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        if(str1.length()==str2.length()){
            char[] strr1=str1.toCharArray();
            char[] strr2=str2.toCharArray();
            if(Arrays.equals(strr1, strr2)){
                System.out.println(str1+"and"+str2+"are anagrams");
            }
        } else{
            System.out.println("not anagrams");
        }


    }
}
