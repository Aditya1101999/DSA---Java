package loops;

import java.util.Scanner;

public class forone {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.println("* * * *");
        }
    }
}
