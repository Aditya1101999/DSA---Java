package loops;

import java.util.Scanner;

public class swi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first no.");
        int a=sc.nextInt();
        System.out.println("enter second no.");
        int b=sc.nextInt();
        System.out.println("enter operator");
        char operator=sc.next().charAt(0);
        //.charAt(0) used to convert char to string
        switch(operator){
            case '+':
                int sum=a+b;
                System.out.println("sum is "+sum);
                break;
            case '-':
                int diff=a-b;
                System.out.println("diff is "+diff);
                break;
            case '*':
                int product=a*b;
                System.out.println("product is "+product);
                break;
            case '/':
                int div=a/b;
                System.out.println("div is "+div);
                break;
            case '%':
                int mod=a%b;
                System.out.println("mod is "+mod);
                break;
            default:
                System.out.println("inavlid operator");
        }
    }
}
