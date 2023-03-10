package loops;

import java.util.Scanner;

public class cont {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("enter no.");
            int n=sc.nextInt();
            if(n%10==0){
                continue;
            }
            System.out.println(n);
        }while(true);
    }
}

