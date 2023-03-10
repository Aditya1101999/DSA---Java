package DivideAndConq;
import java.util.*;
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    public int mergeSort(int arr[],int si,int ei){
        int invCount=0;
        if(si<ei) {
            int mid = si + (ei - si) / 2;//to avoid overflow
            invCount = mergeSort(arr, si, mid);//left
            invCount += mergeSort(arr, mid + 1, ei);//right
            invCount += merge(arr, si, mid, ei);
        }
        return invCount;
    }
    private int merge(int[] nums,int low,int mid,int high){
        int invCount=0;
        int j=mid+1;
        for(int i=low;i<mid+1;i++){
            while(j<=high&&nums[i]>(2*(long)nums[j])){//condition met
                j++;
            }
            invCount+=(j-(mid+1));
        }
        //merge
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while(left <= mid && right<=high) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]);
            }
            else {
                temp.add(nums[right++]);
            }
        }

        while(left<=mid) {
            temp.add(nums[left++]);
        }
        while(right<=high) {
            temp.add(nums[right++]);
        }

        for(int i = low; i<=high;i++) {
            nums[i] = temp.get(i - low);
        }
        return invCount;
    }
}
