package DSAinJava.DivideAndConq;

public class Kthargest {
    public int findKthLargest(int[] nums, int k) {
        int start=0;
        int end=nums.length-1;
        int reqIndex=nums.length-k;
        while(start<=end){
            int pivot=partition(nums,start,end);
            if(pivot==reqIndex){
                return nums[reqIndex];
            }
            else if(pivot>reqIndex){
                end=pivot-1;
            }
            else{
                start=pivot+1;
            }
        }
        return nums[start];//corner case
    }
    private int partition(int[] nums,int start,int end){
        int pivot=end;
        int i=start;
        int j=end;
        while(i<j){
            while(i<j && nums[i]<=nums[pivot]){
                i++;
            }
            while(i<j && nums[j]>=nums[pivot]){
                j--;
            }
            swap(nums,i,j);
        }
        swap(nums,i,pivot);//making correct element to be pivot
        return i;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
