package DSAinJava.DynProg;
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return recurse(triangle,0,0,dp);
    }
    private int recurse(List<List<Integer>> triangle,int row,int col,int[][] dp){
        if(row==triangle.size()){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int minimum=Math.min(recurse(triangle,row+1,col,dp),recurse(triangle,row+1,col+1,dp));
        return dp[row][col]=triangle.get(row).get(col)+minimum;
    }
    public int minimumTotalTab(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){//for all rows
            for(int j=0;j<=i;j++){//for each row-column loop
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
