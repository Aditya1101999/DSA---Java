package DynProg;
import java.util.*;
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;//empty string can be segmented easily
        for(int i=1;i<n+1;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        ArrayList<String> wordDict=new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        //wordDict = {"leet","code"};
        System.out.println(wordBreak(s,wordDict));
    }
}
