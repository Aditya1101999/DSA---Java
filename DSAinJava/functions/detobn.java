package functions;

public class detobn {
    public static void binaryToDecimal(int n){
        int n1=n;
        int pow=0;
        int binary=0;
        while(n>0){
            int re=n%2;
            binary=binary+re*(int)(Math.pow(10,pow));
            pow++;
            n=n/2;
        }
        System.out.println("decimal of "+n1+"is "+binary);

        }
    public static void main(String args[])    {
        binaryToDecimal(11);
    }
}
