package loops;

import java.util.Scanner;

public class coafive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter year no.");
        int a = sc.nextInt();

        boolean x=(a % 4) == 0;
        boolean y=(a%100)!=0;
        boolean z=((a%100==0) && (a%400==0));
        //if year is divided by 100 only,its a century
        if (x &&(y||z)) {
            System.out.println("leap year");
        } else {
            System.out.println("not leap year");
        }
    }
}

