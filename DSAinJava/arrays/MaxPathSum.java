package DSAinJava.arrays;
import java.util.*;
public class MaxPathSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            int[] arr2 = new int[m];
            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }
            int i = 0;
            int j = 0;
            int sum1 = 0;
            int sum2 = 0;
            int ans = 0;
            while (i < n && j < m) {
                if (arr1[i] < arr2[j]) {
                    sum1 += arr1[i];
                    i++;
                } else if (arr2[j] < arr1[i]) {
                    sum2 += arr2[j];
                    j++;
                } else {
                    ans += Math.max(sum1, sum2) + arr1[i];
                    sum1 = 0;
                    sum2 = 0;
                    i++;
                    j++;
                }
            }
            while (i < n) {
                sum1 += arr1[i];
                i++;
            }
            while (j < m) {
                sum2 += arr2[j];
                j++;
            }
            ans += Math.max(sum1, sum2);
            System.out.println(ans);
        }
    }
}
