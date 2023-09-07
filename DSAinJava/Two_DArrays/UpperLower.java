package DSAinJava.Two_DArrays;
import java.util.*;
public class UpperLower {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int upper=0;
        int lower=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<=j) upper+=matrix[i][j];
                if(i>=j) lower+=matrix[i][j];
            }
        }
        System.out.print(upper+" "+lower);
    }
}
