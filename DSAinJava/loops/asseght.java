package loops;

import java.util.LinkedList;
import java.util.Scanner;

public class asseght {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int sum1=0;
        int sum2=0;
        do {
            System.out.println("enter no.s");
            int n = sc.nextInt();
            if (n % 2 == 0) {
                sum1 = sum1 + n;
            }
            else{
                    sum2 = sum2 + n;
                }
            System.out.println("press 1 to cont. and 0 to terminate");
            choice=sc.nextInt();
        }while(choice==1);
        System.out.println("Sum of even numbers: "+sum1);
        System.out.println("Sum of odd numbers: "+sum2);


    }
}
