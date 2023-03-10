package functions;

import java.util.*;
public class funtree {
    public static int factorial(int a) {
        int f = 1;
        for (int i = 1; i <= a; i++) {
            f *= i;

        }
        return f;
    }
    public static int bncoff(int n,int r){
        int nfac=factorial(n);
        int rfac=factorial(r);
        int afac=factorial(n-r);
        int binco=nfac/(rfac*afac);
        return binco;
    }
    public static void main(String args[]){
        int fac=factorial(4);
        System.out.println(fac);
        int binco=bncoff(5,2);
        System.out.println(binco);
    }
}