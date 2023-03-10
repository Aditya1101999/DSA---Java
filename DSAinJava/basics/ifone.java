package basics;

import java.util.Scanner;

public class ifone {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a");
        int a=sc.nextInt();
        System.out.println("enter b");
        int b=sc.nextInt();
        if(a>b){
            System.out.println("a is big");
        }
        if(b>a) {
            System.out.println("b is big");
        }
        else{
            System.out.println("equal");
        }



    }
}