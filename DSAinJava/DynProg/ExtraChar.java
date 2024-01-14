package DSAinJava.DynProg;
import java.util.*;
public class ExtraChar {
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        Set<String>dict=new HashSet<>(Arrays.asList(dictionary));
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(s,dict,dp,0);
    }
    private int solve(String s,Set<String>dict,int[] dp,int index){
        int n=s.length();
        if(index==n){
            return 0;
        }
        if(dp[index]!=-1) return dp[index];

        int ans=n;
        StringBuilder sb=new StringBuilder();
        for(int i=index;i<n;i++){
            sb.append(s.charAt(i));
            int currExtra=(dict.contains(sb.toString())) ? 0 : sb.length();
            int restExtra=solve(s,dict,dp,i+1);
            ans=Math.min(ans,currExtra+restExtra);
        }
        return dp[index]=ans;
    }
}
