package Recursion;
import java.util.*;
public class Descnos {
    public static void printDecNos(int n){
        //base case
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        //calling the same function
        printDecNos(n-1);
    }
    public static void main(String args[]) {
        int n = 10;
        printDecNos(n);
    }

}
