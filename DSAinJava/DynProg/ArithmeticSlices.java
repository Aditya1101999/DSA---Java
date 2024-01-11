package DSAinJava.DynProg;
import java.util.*;
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        //int[] dp=new int[nums.length];
        int prev=0;
        int total=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                //dp[i]=dp[i-1]+1;
                prev++;
            }
            else{
                prev=0;//dp[i]=0;
            }
            total+=prev;
        }
        return total;
    }
    public int numberOfArithmeticSlicesSubsequences(int[] nums) {
        int n=nums.length;
        int ans=0;
        Map<Long,Integer>[]map=new HashMap[n];//<Differences,Frequencies>
        for(int i=0;i<n;i++){
            map[i]=new HashMap<>();
            for(int j=0;j<i;j++){
                long diff=(long)nums[i]-nums[j];

                int subsequencesTillj=map[j].getOrDefault(diff,0);
                ans+=subsequencesTillj;
                //current difference
                map[i].put(diff,map[i].getOrDefault(diff,0)+subsequencesTillj+1);
            }
        }
        return ans;
    }
}
