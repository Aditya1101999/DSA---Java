package patterns;

import java.util.Scanner;

public class pattwo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no. of lines");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            //no. of stars=n-i+1;e.g.:4-1+1=4
            for (int j = 1; j <=(n-i+1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
