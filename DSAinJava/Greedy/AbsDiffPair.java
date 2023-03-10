package Greedy;
import java.util.*;
public class AbsDiffPair {
    public static void main(String[] args){
        //o(n) for loop and log n for sorting->o (n log n)
        int[] A={4,1,8,7};
        int[] B={2,3,6,5};
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff=0;

        for(int i=0;i<A.length;i++){
            //abs function used for absolute value
            minDiff+=Math.abs(A[i]-B[i]);
        }
        System.out.println("min abs diff is "+minDiff);
    }
}
