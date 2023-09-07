package DSAinJava.arrays;
import java.util.Scanner;
public class SortedSquares {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        for (int i = 0; i < n; i++) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                res[index] = leftSquare;
                left++;
            } else {
                res[index] = rightSquare;
                right--;
            }
            index--;
        }
        for (int el : res) {
            System.out.print(el + " ");
        }
    }
}
