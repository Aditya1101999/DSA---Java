package functions;

import java.util.*;
public class palindrme {
    public static boolean palindrome(int n){
        int n1=n;
        int rev=0;
        while(n>0){
            int r=n%10;
            rev=rev*10+r;
            n=n/10;

        }
        if(rev==n1){
            return true;
        }
        else{
            return false;
        }


    }
    public static void main(String args[]){
        System.out.println(palindrome(121));
    }

}
