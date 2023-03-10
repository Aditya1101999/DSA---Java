package loops;

import java.util.Scanner;

public class elseiftwo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first no.");
        int a = sc.nextInt();
        System.out.println("enter second no.");
        int b = sc.nextInt();
        System.out.println("enter third no.");
        int c = sc.nextInt();
        if ((a <=b) && (c<=b)) {
            System.out.println(b);
        } else if(c<=a) {
            System.out.println(a);
        } else {
             System.out.println(c);
        }

    }
}

