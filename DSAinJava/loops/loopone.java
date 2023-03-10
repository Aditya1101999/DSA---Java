package loops;

import java.util.Scanner;

public class loopone {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter start point");
        int a=sc.nextInt();
        System.out.println("enter end point");
        int n=sc.nextInt();
        while(a<=n){
            System.out.print(a+" ");
            a++;

        }
    }
}
