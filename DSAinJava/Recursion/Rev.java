package DSAinJava.Recursion;
import java.util.Scanner;
public class Rev {
    private static void reverseArray(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        reverseArray(nums, start + 1, end - 1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        reverseArray(nums, 0, n - 1);
        for (int el : nums) {
            System.out.print(el + " ");
        }
    }
}
