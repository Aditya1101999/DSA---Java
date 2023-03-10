package Recursion;

public class NoToString {
    static String digits[]={"zero","one","two","three","four",
    "five","six","seven","eight","nine"};
    public static void stringConverter(int n){
        //base case
        if(n==0){
            return;
        }
        int lastDigit=n%10;
        //calling the function for rest no.
        stringConverter(n/10);
        System.out.print(digits[lastDigit]+" ");
    }
    public static void main(String args[]){
        stringConverter(1947);
    }
}
