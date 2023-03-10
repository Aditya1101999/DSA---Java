package DynProg;

public class MountainArray {
    public static int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int result=0;
        for(int i=1;i<n;i++){//Longest Increasing Subsequence
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    left[i]=Math.max(left[i],left[j]+1);
                }
            }
        }
        int[] right=new int[n];
        for(int i=n-2;i>=0;i--){//Longest Decreasing Subsequence
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j]){
                    right[i]=Math.max(right[i],right[j]+1);
                }
            }
        }
        for(int i=1;i<n;i++){
            if(left[i]!=0 &&right[i]!=0){
                result=Math.max(result,left[i]+right[i]);//LIS+LDS
            }
        }
        //Total elements-size of mountain array(LIS+LDS+1->peak element)
        return n-(result+1);
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println(minimumMountainRemovals(nums));
    }
}
