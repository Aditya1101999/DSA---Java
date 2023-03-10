package loops;

import java.util.Scanner;

public class ternery {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter marks");
        int marks=sc.nextInt();
        String result=(marks>=33)?"pass":"fail";
        System.out.println(result);
    }
}
