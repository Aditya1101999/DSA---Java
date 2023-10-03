package DSAinJava.DynProg;
import java.util.*;
public class StringChain {
    public static int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[n];
        int max=1;
        Arrays.fill(dp,1);
        for(int index=0;index<n;index++){
            for(int prev=0;prev<index;prev++){
                if(checkPossible(words[index],words[prev])){
                    dp[index]=Math.max(dp[index],1+dp[prev]);
                }
            }
            max=Math.max(max,dp[index]);
        }
        return max;
    }
    private static boolean checkPossible(String s1,String s2){
        if(s1.length()!=1+s2.length()){
            return false;
        }
        int first=0;
        int second=0;
        while(first<s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else{//insertion in larger string
                first++;
            }
        }
        if((first == s1.length()) && (second == s2.length())){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String[] words={"abcd","dbqca"};
        System.out.println(longestStrChain(words));
    }
}
