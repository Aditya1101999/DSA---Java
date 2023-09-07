package DSAinJava.Strings;
import java.util.Scanner;
public class FaishonableInt {
    private static boolean check(String num) {
        int sum = 0;
        int length = num.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            sum += digit;
            if (digit % 2 == 0) return false;
        }

        return sum % 2 == 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String num = sc.next();
        if (check(num)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
