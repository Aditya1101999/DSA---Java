package basics;

import java.util.Scanner;

public class qsone {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 1st number");
        int a = sc.nextInt();
        System.out.println("enter 2nd number");
        int b = sc.nextInt();
        System.out.println("enter 3rd number");
        int c = sc.nextInt();
        int average = (a + b + c) / 3;
        System.out.println("average is " + average);
    }
}
