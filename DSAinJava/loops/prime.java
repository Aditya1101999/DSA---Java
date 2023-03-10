package loops;

import java.util.Scanner;

public class prime {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no.");
        int n = sc.nextInt();

        if (n == 2) {
            System.out.println("prime");
        } else {
            boolean isPrime = true;
            //checking whether the no. is divisble by any no.s from 2 to no.s
            //for (int i = 2; i < n; i++) {
            //time complexity is very large in this case
            for (int i = 2; i <= Math.sqrt(n); i++) {
                //running loop only till root of n for less time complexity
                if (n % i == 0) {
                    isPrime = false;
                }

            }
            if (isPrime == true) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }
    }

}

