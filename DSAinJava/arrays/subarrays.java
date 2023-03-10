package arrays;
import java.util.*;
public class subarrays {
    public static void print_subarrays(int numbers[]){
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int SA=0;
        //start
        for(int i=0;i< numbers.length;i++ ){
            //end
            for(int j=i;j< numbers.length;j++){
                sum=0;
                //PRINT
                for(int k=i;k<=j;k++) {
                    //SUBARRAYS
                    System.out.print(numbers[k] + " ");
                    //sum of arrays(brute force)
                    sum+=numbers[k];

                }
                System.out.println(sum);
                SA++;
                if(maxSum<sum){
                    maxSum=sum;
                }
                if(minSum>sum){
                    minSum=sum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total arrays are "+SA);
        System.out.println("maximum sum is"+maxSum);
        System.out.println("minimum sum is"+minSum);



    }
    public static void main(String args[]) {
        int numbers[] = {2, 4, 6, 8, 10};
        print_subarrays(numbers);
    }

}
