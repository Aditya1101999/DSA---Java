package DSAinJava.Strings;
import java.util.*;
public class KMP {
    int[] lps(String s) {
        int n=s.length();
        int[] prefixSuffix=new int[n];
        int pre=0;
        int suff=1;
        while(suff<n){
            if(s.charAt(pre)==(s.charAt(suff))){
                prefixSuffix[suff]=pre+1;
                pre++;
                suff++;
            }
            else{
                if(pre==0){
                    prefixSuffix[suff]=0;
                    suff++;
                }
                else{
                    pre=prefixSuffix[pre-1];
                }
            }
        }
        return prefixSuffix;
    }

    ArrayList<Integer> search(String pat, String txt) {
        int[] lps=lps(pat);
        ArrayList<Integer>ans=new ArrayList<>();
        int first=0;
        int second=0;
        while(first<txt.length()){
            if(txt.charAt(first)==pat.charAt(second)){
                first++;
                second++;
            }
            if(second==pat.length()){
                ans.add(first-second+1);//1 based indexing
                second=lps[second-1];
            }
            else if (first<txt.length() && txt.charAt(first) != pat.charAt(second)) {
                if(second==0) first++;
                else{
                    second=lps[second-1];
                }
            }
        }
        return ans;
    }
}
