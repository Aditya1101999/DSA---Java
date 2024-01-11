package DSAinJava.DynProg;
import java.util.Arrays;
public class ReachPositionK {
    public int numberOfWays(int startPos, int endPos, int k) {
        int distance = Math.abs(endPos - startPos);
        int[][] memo = new int[k + 1][distance + k + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(memo[i], -1);
        }
        return solve(k, distance, memo);
    }

    private int solve(int k, int distance, int[][] memo) {
        if (k <= distance) {
            return k == distance ? 1 : 0;
        }
        int mod = (int) 1e9 + 7;
        if (memo[k][distance] != -1) {
            return memo[k][distance];
        }

        memo[k][distance] = (solve(k - 1, distance + 1, memo) + solve(k - 1, Math.abs(distance - 1), memo)) % mod;
        return memo[k][distance];
    }
}
