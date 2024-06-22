package DSAinJava.arrays;
import java.util.Arrays;
public class MinInc {
    public int minIncrementForUnique(int[] nums) {
        int n=nums.length;
        int max=Arrays.stream(nums).max().orElse(0);
        int[] freq=new int[n+max];
        for(int el : nums) freq[el]++;
        int ans=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>1){
                int extra=freq[i]-1;
                ans+=extra;//adding 1 to all extra frequencies
                freq[i+1]+=extra;
                //freq[i]=1;
            }
        }
        return ans;
    }
}
