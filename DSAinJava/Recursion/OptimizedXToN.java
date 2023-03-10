package Recursion;

public class OptimizedXToN {
    public static int xToPowerN(int x,int n) {
        if (n == 0) {
            return 1;
        }
        if(n<0){
            n=-n;
            x=1/x;
        }
        /*if(n%2==0){
            return xToPowerN(x,n/2)*xToPowerN(x,n/2);
        }
        else{
            return x*xToPowerN(x,n/2)*xToPowerN(x,n/2);
        }
    } or,*/
        int halfPower = xToPowerN(x, n / 2);
        int halfPowersq = halfPower * halfPower;
        //n is odd
        if (n % 2 != 0) {
            halfPowersq = x * halfPowersq;
        }
        return halfPowersq;
    }
    public double myPow1(double x, int n) {
        if(n==0) return 1.0;
        double halfPower = myPow(x, n / 2);
        double halfPowersq = halfPower * halfPower;
        if(n%2==0) return halfPowersq;
        else if(n%2==1) return x*halfPowersq;
        else return 1/myPow(x,-n);
    }
    public double myPow(double x, int n) {
        double ans=1.0;
        long nn=n;
        if(nn<0) nn=-1*nn;
        while(nn>0){
            if(nn%2==1){//power is odd
                ans=ans*x;
                n=n-1;
            }
            else{
                x=x*x;
                nn=nn/2;
            }
        }
        if(n<0) ans=(double)1.0/(double)ans;//-ve case
        return ans;
    }

    public static void main(String args[]){
        System.out.println(xToPowerN(2,5));
    }
}

