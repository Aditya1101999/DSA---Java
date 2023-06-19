package arrays;
import java.util.*;
public class presubarr {
    public static void print_maxsubarray_sum(int numbers[]){
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        //new prefix array
        int[] prefix=new int[numbers.length];
        prefix[0]=numbers[0];
        //prefix array calculation
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+numbers[i];
        }
        //start
        for(int i=0;i< numbers.length;i++ ){
            //end
            for(int j=i;j< numbers.length;j++){
                //if start=0,sum=prefix[end]
                if (i == 0) {
                    sum=prefix[j];
                }
                else {
                    sum = prefix[j] - prefix[i - 1];
                }
                if(maxSum<sum){
                    maxSum=sum;
                }
            }
            System.out.println();
        }
        System.out.println("maximum sum is"+maxSum);
    }
    public int largestAltitude(int[] gain) {
        int maxAltitude=0;
        int sum=0;
        for(int el: gain){
            sum+=el;
            maxAltitude=Math.max(maxAltitude,sum);
        }
        return maxAltitude;
    }
    public static void main(String args[]) {
        int numbers[] = {2, 4, 6, 8, 10};
        print_maxsubarray_sum(numbers);
    }

}
