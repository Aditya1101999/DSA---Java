package functions;

import java.util.*;
public class funone {
    public static void printhelloworld(){
        System.out.println("hello world");
        return;
    }
    public static int calculatesum(int num1,int num2){//parameters
        int sum=num1+num2;
        System.out.println(sum);
        return sum;

    }
    public static void main(String args[]) {
        //calling the function
        printhelloworld();
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int sum=calculatesum(a,b);//arguements
    }
}
