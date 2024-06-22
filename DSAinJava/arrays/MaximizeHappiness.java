package DSAinJava.arrays;
import java.util.Arrays;
public class MaximizeHappiness {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum=0;
        int count=0;
        int index=happiness.length-1;
        while(k-->0){
            if(count<happiness[index])sum+=happiness[index]-count;
            index--;
            count++;
        }
        return sum;
    }
}
