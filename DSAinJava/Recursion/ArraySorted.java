package Recursion;

import java.util.Scanner;

public class ArraySorted {
    public static boolean sortedArrayCheck(int array[],int i){
        //base condition
        if(i== array.length-1){
            return true;
        }
        if(array[i]>array[i+1]){
            return false;
        }
        return sortedArrayCheck(array,i+1);


    }

    public static void main(String args[]){
        int array[]={1,2,3,4,5};
        System.out.println(sortedArrayCheck(array,0));
    }
}
