package DSAinJava.arrays;
import java.util.Arrays;
public class DistanceArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count=0;
        for(int el : arr1){
            int low=el-d;
            int high=el+d;
            if(binarySearchInRange(arr2,low,high)) count++;
        }
        return count;
    }
    private boolean binarySearchInRange(int[] arr, int low, int high) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = arr[mid];

            if (midValue >= low && midValue <= high) {
                return false;
            } else if (midValue < low) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return true;
    }
}
