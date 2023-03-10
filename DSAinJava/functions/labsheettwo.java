package functions;

import java.util.*;
public class labsheettwo {
    //1.Geometric progression
    public static void geoProgression(int a, int r) {

        System.out.println("geometric progression is");
        for (int i = 0; i < 15; i++) {
            int term = a * (int) Math.pow(r, i);
            System.out.println(term);

        }


    }
    //2.Fibonacci series
    public static void fibonacci(int n){
        int a=0;
        int b=1;
        System.out.println("Fibonacci series is ");
        System.out.println(a);
        System.out.println(b);
        for(int i=2;i<n;i++){
            int c=a+b;
            System.out.println(c);
            a=b;
            b=c;
        }
    }
    //3.Primes in Range
    public static boolean isPrime(int n){
        if(n==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;

    }
    public static void primesRange(int n){
        System.out.println("primes in range "+n+" are");
        for(int i=2;i<=n;i++){
            if(isPrime(i)==true){
                System.out.println(i);
            }
        }
    }

    public static void main(String args[]) {
        geoProgression(1, 2);
        fibonacci(10);
        primesRange(10);
    }
}
