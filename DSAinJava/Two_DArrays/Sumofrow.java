package Two_DArrays;
import java.util.*;
public class Sumofrow {
    public static int sum_in_a_row(int nums[][]){
        int sum=0;
        for(int j=0;j<nums[0].length;j++){
            //for 2nd row
            sum+=nums[1][j];

        }
        return sum;
    }
    public static void main(String args[]){
        int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
        System.out.println(sum_in_a_row(nums));
}
    }
