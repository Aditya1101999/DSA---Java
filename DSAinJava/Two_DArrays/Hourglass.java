package DSAinJava.Two_DArrays;

public class Hourglass {
    public int maxSum(int[][] grid) {
        int maxSum=-1;
        //all possible A's(starting points)
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                maxSum=Math.max(maxSum,sum(grid,i,j));
            }
        }
        return maxSum;
    }
    private int sum(int[][] grid,int i,int j){// A
        return grid[i][j]+grid[i][j+1]+grid[i][j+2]+
                grid[i+1][j+1]+
                grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
    }
}
