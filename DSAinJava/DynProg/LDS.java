package DynProg;
import java.util.*;
public class LDS {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp=new int[nums.length];
        int size=LDSSize(nums,dp);
        return constructLDS(nums,dp,size);
    }
    private int LDSSize(int[] nums,int[] dp){
        int n=nums.length;
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        int max=1;
        for(int index=1;index<n;index++){
            for(int prev=0;prev<index;prev++){
                if(nums[index]%nums[prev]==0){
                    dp[index]=Math.max(dp[index],1+dp[prev]);
                    max=Math.max(max,dp[index]);
                }
            }
        }
        return max;
    }
    private List<Integer> constructLDS(int[] nums,int[] dp,int size){
        int prev=-1;
        LinkedList<Integer>lds=new LinkedList<Integer>();
        for(int i=dp.length-1;i>=0;i--){
            if(dp[i]==size&&(prev==-1||prev%nums[i]==0)){
                lds.addFirst(nums[i]);
                size--;
                prev=nums[i];
            }
        }
        return lds;
    }
}
