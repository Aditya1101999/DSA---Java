package DSAinJava.DynProg;

public class OutBoundWays {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        // for(int i=0;i<m;i++){
        // for(int j=0;j<n;j++){
        // Arrays.fill(dp[i][j],-1);
        // }
        // }
        // return solve(m,n,maxMove,startRow,startColumn,dp);
        int mod = (int) 1e9 + 7;
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, -1, 0, 1 };
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int ii = 0; ii < 4; ii++) {
                        int x = i + delRow[ii];
                        int y = j + delCol[ii];
                        if (x < 0 || x == m || y < 0 || y == n) {
                            dp[i][j][k]++;
                        }
                        // ans = (ans + solve(m, n, maxMove - 1, x, y, dp)) % mod;
                        else
                            dp[i][j][k] = (dp[i][j][k] + dp[x][y][k - 1]) % mod;
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }

    private int solve(int m, int n, int maxMove, int startRow, int startCol, int[][][] dp) {
        if (startRow < 0 || startRow == m || startCol < 0 || startCol == n) {
            return 1;
        }
        if (maxMove == 0)
            return 0;
        if (dp[startRow][startCol][maxMove] != -1) {
            return dp[startRow][startCol][maxMove];
        }
        int mod = (int) 1e9 + 7;
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, -1, 0, 1 };
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int x = startRow + delRow[i];
            int y = startCol + delCol[i];
            ans = (ans + solve(m, n, maxMove - 1, x, y, dp)) % mod;
        }
        return dp[startRow][startCol][maxMove] = ans;
    }
}
