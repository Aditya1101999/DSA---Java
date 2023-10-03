package DSAinJava.Two_DArrays;
import java.util.*;
public class SearchMatrix {
    public static int search_sorted_matrix(int matrix[][], int target) {
        //staircase search
     /*  int row = matrix.length;
        if (row == 0) {
            return 0; // Matrix is empty
        }

        int col = matrix[0].length;
        int i = row - 1; // Start from the bottom row
        int j = 0; // Start from the first column

        while (i >= 0 && j < col) {
            if (matrix[i][j] == target) {
                return 1; // Element found
            } else if (matrix[i][j] < target) {
                j++; // Move to the right
            } else {
                i--; // Move up
            }
        }

        return 0;
        */
        int row=matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1; // Start from the top-right corner

        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return 1; // Element found
            } else if (matrix[i][j] < target) {
                i++; // Move down
            } else {
                j--; // Move left
            }
        }

        return 0;



    }
    public static void main(String args[]){
        int matrix[][]={{10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,50}};
        int key=33;
        search_sorted_matrix(matrix,key);
    }
}
