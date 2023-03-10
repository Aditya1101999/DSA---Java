package arrays;
import java.util.*;
public class ArraysEqual {
    public static boolean check(long A[],long B[],int n) {
        int a=A.length;
        int b=B.length;
        if(a!=b) return false;
        HashMap<Long,Integer>map=new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){//storing 1st array
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }
        for(int i=0;i<n;i++){
            if(!map.containsKey(B[i]) || map.get(B[i])==0){
                return false;
            }
            map.put(B[i],map.getOrDefault(B[i],0)-1);

        }
        return true;
    }
    public static void main(String[] args)
    {
        long arr1[] = { 3, 5, 2, 5, 2 };
        long arr2[] = { 2, 3, 5, 5, 2 };

        // Function call
        if (check(arr1, arr2,5))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

