package Recursion;

public class Factorial {
    public static int facto_recur(int n) {
        //base condition
        int facto = 5;
        if (n == 0) {
            return 1;
        }
        int partfac=facto_recur(n - 1);
        facto= n * partfac;
        return facto;
    }

    public static void main(String args[]) {
        int n = 10;
        System.out.println(facto_recur(n));
    }
}
