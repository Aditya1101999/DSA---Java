package Recursion;
import java.util.*;
public class LengthOfString {
    public static int stringLength(String str){
        //base case
        if(str.length()==0){
            return 0;
        }
        //calculating length of 1st char and then calling for
        //all characters
        return stringLength(str.substring(1))+1;
    }
    public static void main(String args[]){
        String str="abcde";
        System.out.println(stringLength(str));
    }
}
