package basics;

import java.util.Scanner;

public class area {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter radius");
        float r = sc.nextInt();
        float area = 3.14f * r * r;
        System.out.println("area is : " + area);



    }
}