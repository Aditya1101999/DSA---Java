package advancedPatterns;

import java.util.*;
public class holloRect{
    public static void hollow_rectangle(int Rows,int Columns) {
        //outer loop=rows
        for (int i = 1; i <= Rows; i++) {
            //inner loop=columns
            for (int j = 1; j <= Columns; j++) {
                if (i == 1 || i == Rows || j == 1 || j == Columns) {
                    //boundary cells
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        hollow_rectangle(4,5);


    }
}
