package DynProg;
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        //intialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){//same
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{//diff
                    dp[i][j]=Math.min(Math.min(dp[i][j-1]//add
                            ,dp[i-1][j]),//delete
                            dp[i-1][j-1])+1;//replace
                }
            }
        }
        return dp[n][m];
    }
    public static int minDistanceDeleteOnly(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        //intialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){//same
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{//diff
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+1;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args){
        String str1="intention";
        String str2="execution";
        System.out.println(minDistance(str1,str2));
        System.out.println(minDistanceDeleteOnly(str1,str2));
    }
}
