package DSAinJava.arrays;

public class PatchArr {
    public int minPatches(int[] nums, int n) {
        long maxReach=0;
        int patches=0;
        int i=0;
        while(maxReach<n){
            if(i<nums.length && nums[i]<=maxReach+1){
                maxReach+=nums[i];
                i++;
            }
            else{
                maxReach+=maxReach+1;
                patches++;
            }
        }
        return patches;
    }
}
