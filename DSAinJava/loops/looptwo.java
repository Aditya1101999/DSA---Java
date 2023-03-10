package loops;

import java.util.Scanner;

public class looptwo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter start point");
        int a = sc.nextInt();
        System.out.println("enter end point");
        int n = sc.nextInt();
        int sum = 0;
        while (a <= n) {
            sum+=a;
            a++;

        }
        System.out.println(sum);
    }
}
