package DSAinJava.arrays;
import java.util.*;
public class RelativeSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n=arr1.length;
        int[] result=new int[n];
        int max=Arrays.stream(arr1).max().orElse(0);
        int[] freq=new int[max+1];
        for(int el : arr1){
            freq[el]++;
        }
        int index=0;
        //sort according to relative
        for(int el : arr2){
            while(freq[el]-->0){
                result[index++]=el;
            }
        }
        for(int i=0;i<max+1;i++){
            while(freq[i]-->0) result[index++]=i;
        }
        return result;
    }
}
