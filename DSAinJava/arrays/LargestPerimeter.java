package DSAinJava.arrays;
import java.util.Arrays;
public class LargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum=0;
        long ans=-1;
        for(int el : nums){
            if(sum>el) ans=sum+el;
            sum+=el;
        }
        return ans;
    }
}
