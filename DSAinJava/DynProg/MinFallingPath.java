package DynProg;

public class MinFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp = new int[n][n];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++)   {
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                }
                else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dp[n-1][i] < min)  min = dp[n-1][i];
        }
        return min;
    }
    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int min = Integer.MAX_VALUE;

        // Initialize the first row of dp with the first row of matrix
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }

        // For each row starting from the second
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                // Initialize dp[i][j] to a large value
                dp[i][j] = Integer.MAX_VALUE;
                // For each column of the previous row
                for(int k = 0; k < n; k++){
                    // If it's not in the same column
                    if(k != j){
                        // Choose the minimum between the current dp[i][j] and matrix[i][j] + dp[i-1][k]
                        dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i-1][k]);
                    }
                }
            }
        }

        // Find the minimum in the last row of dp
        for(int i = 0; i < n; i++){
            min = Math.min(min, dp[n-1][i]);
        }

        return min;
    }

}
