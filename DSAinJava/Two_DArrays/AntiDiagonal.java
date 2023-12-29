package DSAinJava.Two_DArrays;
import java.util.*;
public class AntiDiagonal {
    private void antiDiagonalTraversal(int[][] matrix,List<Integer>ans,int currRow,int currCol){
        while(currRow<matrix.length && currCol>=0){
            ans.add(matrix[currRow][currCol]);
            currRow++;
            currCol--;
        }
    }
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        int n=matrix.length;
        List<Integer>ans=new ArrayList<>();
        //1st row and all columns
        for(int j=0;j<n;j++){
            antiDiagonalTraversal(matrix,ans,0,j);
        }
        //last column and all rows from 1
        for(int i=1;i<n;i++){
            antiDiagonalTraversal(matrix,ans,i,n-1);
        }
        int[] arr=new int[n*n];
        int idx=0;
        for(int el : ans){
            arr[idx++]=el;
        }
        return arr;
    }
}
