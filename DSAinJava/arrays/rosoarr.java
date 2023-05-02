package arrays;
import java.util.*;
public class rosoarr {
    public static int rotated_sorted_array(int nums[],int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low+(high-low) / 2;//(low+high)/2
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[low] < nums[mid]) {
                //left array is sorted
                if (target < nums[low] || target > nums[mid]) {
                    //if element does not lie in left array
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[low] > nums[mid]) {
                //right array is sorted
                if (target > nums[mid] || target < nums[high]) {
                    //if element does not lie in right array
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }
        return -1;
    }
    public class Solution {
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end){
                int mid = (start + end) / 2;
                if (nums[mid] == target)
                    return mid;

                if (nums[start] <= nums[mid]){
                    if (target < nums[mid] && target >= nums[start])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }

                if (nums[mid] <= nums[end]){
                    if (target > nums[mid] && target <= nums[end])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }
            return -1;
        }
        public boolean searchWithDuplicates(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end){
                int mid = start+(end-start) / 2;
                if (nums[mid] == target)
                    return true;

                if (nums[start] < nums[mid]){
                    if (target < nums[mid] && target >= nums[start])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }

                else if (nums[start] > nums[mid]){
                    if (target > nums[mid] && target <= nums[end])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
                else{//start==mid->duplicates
                    start++;
                }
            }
            return false;
        }
    }
    public static void main(String args[]){
        int nums[]={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(rotated_sorted_array(nums,target));
    }
}
