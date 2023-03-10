package DynProg;

public class StringConversion {
    public static int StrCon(String str1,String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                //same
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {//diff
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        int ans=dp[m][n];
        int inserts=m-ans;
        int deletes=n-ans;
        System.out.println("inserts are :"+inserts);
        System.out.println("deletes are :"+deletes);
        return inserts+deletes;
    }

    public static void main(String[] args){
        String str1="pear";
        String str2="sea";
        System.out.println(StrCon(str1,str2));
    }
}
