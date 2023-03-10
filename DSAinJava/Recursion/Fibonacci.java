package Recursion;

public class Fibonacci {
    public static int fibonacciNo(int n) {
        //base condition
       /* if (n == 0) {
            return 0;
        }
        if(n==1){
            return 1;
        } or*/
        if(n==0||n==1) {
            return n;
        }
        int pastsum = fibonacciNo(n - 1);
        int passum1 = fibonacciNo(n - 2);
        return pastsum + passum1;
    }
    public static void main(String args[]) {
        int n = 10;
        System.out.println(fibonacciNo(n));
    }
}

