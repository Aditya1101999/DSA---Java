package DSAinJava.Strings;
import java.util.*;
public class LockKeys {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine(); // Consume the newline
            String S = sc.nextLine();
            String K = sc.nextLine();

            int minMoves = Integer.MAX_VALUE;

            for (int i = 0; i <= N - M; i++) {
                int moves = 0;
                for (int j = 0; j < M; j++) {
                    int diff = Math.abs(S.charAt(i + j) - K.charAt(j));
                    moves += Math.min(diff, 10 - diff);
                }
                minMoves = Math.min(minMoves, moves);
            }

            System.out.println(minMoves);
        }
    }
}
