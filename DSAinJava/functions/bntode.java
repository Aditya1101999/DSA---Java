package functions;

public class bntode {
    public static void binaryToDecimal(int n){
        int n1=n;
        int pow=0;
        int decimal=0;
        while(n>0){
            int lastDigit=n%10;
            decimal=decimal+(lastDigit*(int)(Math.pow(2,pow)));
            pow++;
            n=n/10;
        }
        System.out.println("decimal of "+n1+"is"+decimal);
    }
    public static void main(String args[]){
        binaryToDecimal(101);
    }
}
