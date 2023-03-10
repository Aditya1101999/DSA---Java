package Recursion;
import java.util.*;
public class Incnos {
    public static void printIncNos(int n) {
        //base case
        if(n==1){
            System.out.println(n);
            return;
        }
        printIncNos(n-1);
        System.out.println(n);
    }
    public static void main(String args[]) {
        int n = 10;
        printIncNos(n);
    }


}
