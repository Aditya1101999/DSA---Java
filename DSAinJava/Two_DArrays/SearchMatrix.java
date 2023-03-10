package Two_DArrays;
import java.util.*;
public class SearchMatrix {
    public static boolean search_sorted_matrix(int matrix[][], int key) {
        //staircase search
        /*int row = 0;
        int col = matrix[0].length - 1;
        while(row<matrix.length && col>=0) {
            if (matrix[row][col] == key) {
                System.out.println("element found at (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                //moving towards left
                col--;
            } else {
                //moving towards bottom
                row++;
            }
        }*/
        int col = 0;
        int row = matrix[0].length - 1;
        while(col<matrix.length && row>=0) {
            if (matrix[row][col] == key) {
                System.out.println("element found at (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                //moving towards top
                row--;
            } else {
                //moving towards right
                col++;

            }
        }
        System.out.println("key not found");
        return false;



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
