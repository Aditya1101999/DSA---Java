package DSAinJava.arrays;
import java.util.Scanner;
public class MakeArrayEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int operations=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cost=0;
            for(int j=0;j<n;j++){
                cost+=Math.min(arr[j],Math.abs(arr[j]-arr[i]));
            }
            operations=Math.min(operations,cost);
        }
        System.out.println(operations);
    }
}
