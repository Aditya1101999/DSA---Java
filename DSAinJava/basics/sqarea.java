package basics;

import java.util.Scanner;

public class sqarea {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter side");
        float r = sc.nextInt();
        float area = r * r;
        System.out.println("area is : " + area);
    }
}
