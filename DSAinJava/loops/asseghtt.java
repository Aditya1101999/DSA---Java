package loops;

import java.util.Scanner;

public class asseghtt {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number for factorial");
        int n=sc.nextInt();
        int fa=1;
        if(n>=0){
            for(int i=1;i<=n;i++){
                fa*=i;
            }
        System.out.println(fa);

        }
        else{
            System.out.println("please enter a +ve number!!");
        }
    }
}
