package DSAinJava.arrays;

public class SortParity {
    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]%2>nums[j]%2){
                swap(nums,i,j);
            }
            if(nums[i]%2==0) i++;
            if(nums[j]%2==1) j--;
        }
        return nums;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
