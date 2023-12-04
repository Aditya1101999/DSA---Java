package DSAinJava.Strings;
import java.util.*;
public class PalindromicSubsequences {
    public int countPalindromicSubsequenceWithSpace(String s) {
        int n=s.length();
        Set<Character>letters=new HashSet<>();
        for(char c : s.toCharArray()) letters.add(c);

        int result=0;
        for(char letter : letters){
            int i=-1;
            int j=-1;
            for(int k=0;k<n;k++){
                if(s.charAt(k)==letter){
                    if(i==-1) i=k;
                    j=k;
                }
            }
            Set<Character>set=new HashSet<>();
            for(int mid=i+1;mid<j;mid++){
                set.add(s.charAt(mid));
            }
            result+=set.size();
        }
        return result;
    }
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        List<int[]>letters=new ArrayList<>();
        int[] pair={-1,-1};
        for(int i=0;i<26;i++){
            letters.add(pair);
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int index=ch-'a';
            if (letters.get(index)[0] == -1) {
                letters.set(index, new int[]{i, i});
            } else {
                letters.get(index)[1] = i;
            }
        }
        int result=0;
        for(int i=0;i<26;i++){
            int left=letters.get(i)[0];
            int right=letters.get(i)[1];
            if(left!=-1){
                Set<Character>set=new HashSet<>();
                for(int mid=left+1;mid<right;mid++){
                    set.add(s.charAt(mid));
                }
                result+=set.size();
            }
        }
        return result;
    }
}
