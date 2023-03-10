package functions;

import java.util.*;
public class funtwo {
    public static void printhelloworld() {
        System.out.println("hello world");
        return;
    }

    public static int calculatesum(int num1,int num2){//parameters
        int sum = num1 + num2;
        System.out.println(sum);
        return sum;

    }
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println("a is"+a);
        System.out.println("b is"+b);

    }
    public static int product(int a,int b){
        int product=a*b;;
        return product;
    }

    public static void main(String args[]) {
        //swap
        int multi=product(5,3);
        System.out.println(multi);


    }
}
