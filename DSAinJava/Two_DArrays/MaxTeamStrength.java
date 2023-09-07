package DSAinJava.Two_DArrays;
import java.util.*;
public class MaxTeamStrength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        int[][] strength = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                strength[i][j] = scanner.nextInt();
            }
        }

        int[] teamStrength = new int[K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int team = (i + j) % K;
                teamStrength[team] += strength[i][j];
            }
        }

        int maxStrength = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            maxStrength = Math.max(maxStrength, teamStrength[i]);
        }

        System.out.println(maxStrength);
    }
}
