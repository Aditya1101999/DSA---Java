package loops;

import java.util.Scanner;

public class coaone {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no.");
        int a = sc.nextInt();
        if (a >= 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }
}
