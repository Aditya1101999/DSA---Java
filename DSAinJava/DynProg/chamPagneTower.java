package DSAinJava.DynProg;

public class chamPagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp=new double[101][101];
        dp[0][0]=(double)poured;
        for(int i=0;i<=query_row;i++){//row
            for(int j=0;j<=i;j++){//glasses at ith row
                double champagne=Math.max(dp[i][j]-1.0,0.0);
                dp[i+1][j]+=champagne/2;//bottom left
                dp[i+1][j+1]+=champagne/2;//bottom right
            }
        }
        return Math.min(dp[query_row][query_glass],1.0);
    }
}
