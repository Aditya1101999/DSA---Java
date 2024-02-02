package DSAinJava.arrays;

public class canSort {
    public boolean canSortArray(int[] nums) {
        int[] bitCount=new int[nums.length];
        int index=0;
        for(int el : nums){
            bitCount[index++]=Integer.bitCount(el);
        }
        for(int j=0;j<nums.length;j++){
            for(int i=1;i<nums.length;i++){
                if(nums[i]<nums[i-1] && bitCount[i-1]==bitCount[i]){
                    swap(nums,i,i-1);
                }
            }
            if(check(nums)) return true;
        }
        return false;
    }
    private boolean check(int[] nums){
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]) return false;
        }
        return true;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
