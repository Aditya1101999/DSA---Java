package basics;

import java.util.Scanner;

public class iftwo {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a");
        int a=sc.nextInt();

        if(a%2==0){
            System.out.println(" even");
        }
        else{
            System.out.println("odd");
        }



    }
}