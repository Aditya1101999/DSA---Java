package loops;

import java.util.Scanner;

public class fortwo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int n = sc.nextInt();
        while(n>0){
            int lastdigit=n%10;
            n=n/10;
            int rev=0;
            rev=(rev*10)+lastdigit;
            System.out.print(rev);
        }


    }
}