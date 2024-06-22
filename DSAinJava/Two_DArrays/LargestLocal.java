package DSAinJava.Two_DArrays;

public class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int[][] matrix=new int[n-2][n-2];
        for(int i=0;i<n-2;i++){//for all starting points
            for(int j=0;j<n-2;j++){
                matrix[i][j]=findMax(grid,i,j);
            }
        }
        return matrix;
    }
    private int findMax(int[][] grid,int row,int col){
        int max=0;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                max=Math.max(max,grid[i][j]);
            }
        }
        return max;
    }
}
