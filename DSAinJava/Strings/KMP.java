package DSAinJava.Strings;
import java.util.*;
public class KMP {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer>ans=new ArrayList<>();
        List<Integer>aIndices=search(a,s);
        List<Integer>bIndices=search(b,s);
        for (int el1 : aIndices) {
            int leftBound = el1 - k;
            int rightBound = el1 + k;

            if (binarySearchInRange(bIndices, leftBound, rightBound)) {
                ans.add(el1);
            }
        }
        return ans;
    }
    boolean binarySearchInRange(List<Integer> arr, int low, int high) {
        int left = 0, right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = arr.get(mid);

            if (midValue >= low && midValue <= high) {
                return true;
            } else if (midValue < low) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
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
