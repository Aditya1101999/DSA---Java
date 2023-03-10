package DivideAndConq;

public class RotSortArr {
    public static int rotated_sorted_array(int nums[], int target, int low, int high) {
        //base case
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;//(low+high)/2
        if (target == nums[mid]) {
            return mid;
        }
        if (nums[low] < nums[mid]) {
            //left array is sorted
            if (target < nums[low] || target > nums[mid]) {
                //if element does not lie in left array
                //right
                return rotated_sorted_array(nums, target, mid + 1, high);
            } else {//left
                return rotated_sorted_array(nums, target, low, mid - 1);
            }


        } else if (nums[low] > nums[mid]) {
            //right array is sorted
            if (target < nums[mid] || target > nums[high]) {
                //if element does not lie in right array
                //left
                return rotated_sorted_array(nums, target, low, mid - 1);
            }
        } else {
            //right
            return rotated_sorted_array(nums, target, mid + 1, high);
        }
        return -1;
    }
    public static void main(String args[]){
        int nums[]={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(rotated_sorted_array(nums,0,0, nums.length));
        }
    }

