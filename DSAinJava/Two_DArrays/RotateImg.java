package Two_DArrays;

public class RotateImg {
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){//making transpose
            for(int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){//reversing each row with two-pointers
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
