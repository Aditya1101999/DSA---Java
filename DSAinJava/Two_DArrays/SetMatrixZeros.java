package Two_DArrays;

public class SetMatrixZeros {
    public static void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int col=1;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) col=0;//any row in 0th col so that we can update it later
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;//set dummy array's respective row and col
                }
            }
        }
        for(int i=m-1;i>=0;i--){//reverse travsersal in order to reserve dummy arrays
            for(int j=n-1;j>=1;j--){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
            if(col==0) matrix[i][0]=0;
        }
    }
    public static void main(String[] args){
        int[][]  matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
}
