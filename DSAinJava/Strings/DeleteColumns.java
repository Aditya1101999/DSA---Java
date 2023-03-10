package Strings;
import java.util.*;
public class DeleteColumns {
    public static int minDeletionSize(String[] strs) {
        // Initialize delete count to 0
        int deleteCount = 0;
        // Get the number of rows and columns in the grid
        int n = strs.length;
        int m = strs[0].length();
        // Iterate through each column of the grid
        for (int i = 0; i < m; i++) {
            // Iterate through each element in the column
            for (int j = 1; j < n; j++) {
                // If the current element is lexicographically smaller than the previous element,
                // increment delete count and break out of the loop
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    deleteCount++;
                    break;
                }
            }
        }
        return deleteCount;
    }
    public static void main(String[] args){
        String[] strs = {"cba","daf","ghi"};
        System.out.println(minDeletionSize(strs));
    }
}
