package DynProg;
import java.util.*;
public class BoxStacking {
    public int maxHeight(int[][] A) {
        //sort all dimensions
        for(int i=0;i<A.length;i++){
            Arrays.sort(A[i]);
        }
        //sort all cuboids on basis of w or l
        Arrays.sort(A, (a, b) ->(b[0] + b[1] + b[2])-(a[0] + a[1] + a[2]));
        int n = A.length, res = 0, dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = A[i][2];
            for (int j = 0; j < i;j++) {
                if (A[j][0] >= A[i][0] && A[j][1] >= A[i][1] && A[j][2] >= A[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
