package Two_DArrays;
import java.util.*;
public class creation {
    public static boolean search(int matrix[][],int key){
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("found at cell" + "(" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("element not found");
        return false;


    }
    public static void largest_and_smallest(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }

            }
        }
        System.out.println("maximum element is " + max);
        System.out.println("minimum element is " + min);
    }
    public static void main(String args[]) {
        int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length;

        Scanner sc = new Scanner(System.in);
        System.out.println("enter element of matrix");
        //input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        //output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();

        }
        search(matrix,5);
        largest_and_smallest(matrix);
    }
}
