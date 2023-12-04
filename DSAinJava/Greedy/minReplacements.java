package DSAinJava.Greedy;

public class minReplacements {
    public long minimumReplacement(int[] nums) {
        int n=nums.length;
        long result=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]) continue;
            int splits=nums[i]/nums[i+1];
            if(nums[i]%nums[i+1]!=0){
                splits++;
            }
            result+=(splits-1);
            nums[i]=nums[i]/splits;
        }
        return result;
    }
}
