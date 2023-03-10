package Arraylist;
import java.util.ArrayList;
public class MaxSumSubarray {
    static long maximumSumSubarray(int k, ArrayList<Integer> Arr,int n){
        long sum=0;
        for(int i=0;i<k;i++){
            sum+=Arr.get(i);
        }
        long max=sum;
        int start=0;
        for(int i=k;i<n;i++){
            sum+=(Arr.get(i)-Arr.get(start));
            start++;
            max=Math.max(sum,max);
        }
        return max;
    }
}
