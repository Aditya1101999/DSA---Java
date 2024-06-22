package DSAinJava.DynProg;
import java.util.*;
public class LongestIdealSub {
    public int longestIdealString(String s, int k) {
        int[] subsequence=new int[26];
        int ans=0;
        for(char c : s.toCharArray()){
            int character=c-'a';
            int left=Math.max(0,character-k);
            int right=Math.min(25,character+k);
            int maxSub=0;
            for(int i=left;i<=right;i++){
                maxSub=Math.max(maxSub,subsequence[i]);
            }
            subsequence[character]=Math.max(subsequence[character],maxSub+1);
            ans=Math.max(ans,subsequence[character]);
        }
        return ans;
    }
    public static int longestSubseq(int n, int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        int ans=0;
        for (int i = 0; i < n; i++) {
            int freq=1;
            if(map.containsKey(arr[i] + 1) || map.containsKey(arr[i] - 1)){
                freq = 1+ Math.max(map.getOrDefault(arr[i] + 1, 0), map.getOrDefault(arr[i] - 1, 0));
            }
            map.put(arr[i], freq);
            ans=Math.max(ans,freq);
        }
        return ans;
    }
}
