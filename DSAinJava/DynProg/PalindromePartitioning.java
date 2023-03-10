package DynProg;
import java.util.*;
public class PalindromePartitioning {
    public static int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){//cut
                    int cost=1+dp[j+1];//remaining string
                    min=Math.min(min,cost);
                }
            }
            dp[i]=min;
        }
        return dp[0]-1;//it will make a cut on last character of len 1 also
    }
    private static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        String s = "aab";
        System.out.println(minCut(s));
    }
}
