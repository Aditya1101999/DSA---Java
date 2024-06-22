package DSAinJava.DynProg;

public class KPalin {
    public int kPalindrome(String str, int n, int k) {
        StringBuilder sb=new StringBuilder(str);
        String newStr=sb.reverse().toString();
        int common=lcs(str,newStr,n);
        return (n-common)<=k ? 1 : 0;
    }
    private int lcs(String s1,String s2,int n){
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}
