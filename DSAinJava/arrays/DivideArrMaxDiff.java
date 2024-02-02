package DSAinJava.arrays;
import java.util.Arrays;
public class DivideArrMaxDiff {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int[][] ans=new int[n/3][3];
        int index=0;
        for(int i=2;i<n;i+=3){
            if(nums[i]-nums[i-2]>k) return new int[][]{};
            ans[index++]=new int[]{nums[i-2],nums[i-1],nums[i]};
        }
        return ans;
    }
}
