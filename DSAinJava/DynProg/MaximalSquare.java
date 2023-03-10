package DynProg;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        if(n == 0) return 0;
        int[][] dp=new int[m+1][n+1];
        int ans=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(matrix[i-1][j-1]=='1'){//top , left , diagonally up
                    int min=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    dp[i][j]=min+1;
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}
