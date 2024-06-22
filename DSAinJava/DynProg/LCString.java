package DynProg;

public class LCString {
    public static int lcs(String str1,String str2,int n,int m){
        if(n==0||m==0){
            return 0;
        }
        //same characters at last
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return lcs(str1, str2, n-1, m-1)+1;
        }
        else{
            int ans1=lcs(str1, str2, n-1, m);
            int ans2=lcs(str1, str2, n, m-1);
            return Math.max(ans1,ans2);
        }
    }
    public static int memo(String str1,String str2,int n,int m,int dp[][]){
        if(n==0||m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        //same characters at last
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            dp[n][m]=memo(str1, str2, n-1, m-1,dp)+1;
        }
        else{
            int ans1=memo(str1, str2, n-1, m,dp);
            int ans2=memo(str1, str2, n, m-1,dp);
            dp[n][m]=Math.max(ans1,ans2);
        }
        return dp[n][m];
    }
    public static int tab(String str1,String str2,int n,int m){
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //same
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{//diff
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public int longestPalindromeSubseq(String s) {
        StringBuffer sb=new StringBuffer(s);
        //dp[n][m]/2 for maximizing lcs
        return tab(s,sb.reverse().toString(),s.length(), sb.length());
    }
    public int longestPalindromeSubseq2(String s) {//without involving lcs
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
    public int kPalindrome(String str, int n, int k) {
        StringBuilder sb=new StringBuilder(str);
        String newStr=sb.reverse().toString();
        int common=lcs(str,newStr,n,n);
        return (n-common)<=k ? 1 : 0;
    }
    public static void main(String[] args){
        String str1="abcdge";
        String str2="abedg";
        System.out.println(lcs(str1,str2,str1.length(),str2.length()));
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length()+1;i++){
            for(int j=0;j<str2.length()+1;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(memo(str1,str2,str1.length(),str2.length(),dp));
        System.out.println(tab(str1,str2,str1.length(),str2.length()));
    }

}
