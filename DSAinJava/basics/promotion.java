package basics;

import java.util.Scanner;

public class promotion {
    public static void main(String args[]) {
        //example 1
        char a = 'a';
        char b = 'b';
        System.out.println((int) a);
        System.out.println((int) b);
        System.out.println(b - a);

        //example 2
        short c=5;
        byte d=25;
        char e='c';
        byte bt=(byte)(e+d+c);
        System.out.println(bt);

        //example 3
        int f=12;
        float g=13;
        double h=14;
        double i=f+g+h;
        System.out.println(i);
    }
}
