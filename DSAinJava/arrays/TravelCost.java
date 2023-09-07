package DSAinJava.arrays;
import java.util.*;
public class TravelCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            int c3 = scanner.nextInt();
            int c4 = scanner.nextInt();

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[] rickshawRides = new int[n];
            int[] cabRides = new int[m];

            for (int i = 0; i < n; i++) {
                rickshawRides[i] = scanner.nextInt();
            }

            for (int i = 0; i < m; i++) {
                cabRides[i] = scanner.nextInt();
            }

            int totalRickshawCost = 0;
            int totalCabCost = 0;

            for (int i = 0; i < n; i++) {
                totalRickshawCost += Math.min(rickshawRides[i] * c1, c2);
            }

            for (int i = 0; i < m; i++) {
                totalCabCost += Math.min(cabRides[i] * c1, c2);
            }

            int minCost = Math.min(totalRickshawCost, c3) + Math.min(totalCabCost, c3);
            minCost = Math.min(minCost, c4);

            System.out.println(minCost);
        }
    }
}
