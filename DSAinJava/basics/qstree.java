package basics;

import java.util.Scanner;

public class qstree {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter cost of pencil");
        float a = sc.nextFloat();
        System.out.println("enter cost pen");
        float b = sc.nextFloat();
        System.out.println("enter cost eraser");
        float c = sc.nextFloat();
        float amount = a + b + c;
        float gst=amount*0.18f;
        float bill=amount+gst;
        System.out.println("total amount is " + bill);
    }
}

