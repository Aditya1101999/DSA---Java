package basics;

import java.util.Scanner;

public class cast {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = 25;
        float b = a;
        System.out.println(b);

        float c=25.99f;
        int d=(int)c;
        System.out.println(d);

        char ch='a';
        int no=(int)ch;
        System.out.println(no);
    }
}
