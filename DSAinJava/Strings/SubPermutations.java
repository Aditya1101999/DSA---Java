package DSAinJava.Strings;
import java.util.*;
public class SubPermutations {
    public static ArrayList<Integer> substringsAndPermutations(int n, int m, String s,String[] arr) {
        //return brute(n,m,s,arr);
        ArrayList<Integer>ans=new ArrayList<>();
        Map<Character,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            List<Integer>indices=map.getOrDefault(c,new ArrayList<>());
            indices.add(i);
            map.put(c,indices);
        }
        for(String number : arr){
            int[] freq=calculateFreq(number);
            int index=0;
            for(char c : number.toCharArray()){
                if(freq[c-'0']>map.getOrDefault(c,new ArrayList<>()).size()){
                    index=-1;
                    break;
                }
                else{
                    List<Integer>indices=map.get(c);
                    index=Math.max(index,indices.get(freq[c-'0']-1)+1);
                }
            }
            ans.add(index);
        }
        return ans;


    }
    public static ArrayList<Integer> brute(int n, int m, String s,String[] arr) {
        ArrayList<Integer>ans=new ArrayList<>();
        for(String no : arr){
            int[] freq=calculateFreq(no);

            int counter=no.length();
            for(int i=0;i<s.length();i++){
                int c=s.charAt(i)-'0';
                if(freq[c]>0) counter--;
                freq[c]--;
                if(counter==0){
                    ans.add(i+1);
                    break;
                }
                if(i==s.length()-1) ans.add(-1);
            }
        }
        return ans;

    }

    private static int[] calculateFreq(String str){
        int[] freq=new int[10];
        for(char c : str.toCharArray()){
            freq[c-'0']++;
        }
        return freq;
    }
}
