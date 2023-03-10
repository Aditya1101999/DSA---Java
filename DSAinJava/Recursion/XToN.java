package Recursion;

public class XToN {
    public static int xToPowerN(int x,int n){
        if(n==0){
            return 1;
        }
        //int xn1=xToPowerN(x,n-1);
        //return x*xn1; or
        return x*xToPowerN(x,n-1);

    }
    public static void main(String args[]){
        System.out.println(xToPowerN(2,5));
    }
}
