package DSAinJava.DivideAndConq;
import java.util.*;
public class WarriorChef {
    public static boolean isPossible(ArrayList<Long> strengths, long initialStrength, long resistance) {
        long remainingStrength = initialStrength;
        for (long strength : strengths) {
            if (strength <= resistance) {
                continue;
            } else {
                if (remainingStrength > strength) {
                    remainingStrength -= strength;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long initialStrength = scanner.nextLong();
            scanner.nextLine(); // Consume the newline

            ArrayList<Long> strengths = new ArrayList<>();
            long max = 0;

            String[] input = scanner.nextLine().split(" ");
            for (String s : input) {
                long strength = Long.parseLong(s);
                strengths.add(strength);
                max=Math.max(max,strength);
            }

            long left = 0;
            long right = max;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (isPossible(strengths, initialStrength, mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            System.out.println(left);
        }
    }
}
