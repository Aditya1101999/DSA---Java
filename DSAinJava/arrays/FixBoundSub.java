package DSAinJava.arrays;

public class FixBoundSub {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIndex=-1;
        int maxIndex=-1;
        int invalidIndex=-1;
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==minK) minIndex=i;
            if(nums[i]==maxK) maxIndex=i;

            if(nums[i]>maxK || nums[i]<minK) invalidIndex=i;

            if(minIndex!=-1 && maxIndex!=-1){
                int leftIndex=Math.min(minIndex,maxIndex);
                if(leftIndex>invalidIndex){
                    ans+=leftIndex-invalidIndex;
                }
            }
        }
        return ans;
    }
}
