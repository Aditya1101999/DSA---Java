package Recursion;
import java.util.*;
public class Sumnos {
    public static int sumNos(int n){
        //base condition
        if(n==1){
            return n;
            //or
            // if(n==1){
            // return 1;
        }
        int pastSum=sumNos(n-1);
        int sum=n+pastSum;
        return sum;
    }
    public static void main(String args[]) {
        int n = 10;
        System.out.println(sumNos(n));
    }
}
