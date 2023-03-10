package basics;

import java.util.Scanner;

public class elseifone {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter income");
        int a = sc.nextInt();
        if (a < 500000) {
            float tax = 0;
            System.out.println(tax);
        } else if (a > 500000 && a < 1000000) {
            float tax = a * 0.2f;
            System.out.println(tax);
        } else if (a > 1000000) {
            float tax = a * 0.3f;
            System.out.println(tax);
        } else {
            System.out.println("nikal biro");
        }

    }
}

