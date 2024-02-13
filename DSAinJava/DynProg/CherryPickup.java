package DSAinJava.DynProg;

public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][][] dp=new int[rows][cols][cols];
        // for(int i=0;i<rows;i++){
        //     for(int j=0;j<cols;j++){
        //         Arrays.fill(dp[i][j],-1);
        //     }
        // }
        // return solve(grid,0,0,cols-1,dp);
        //dp[row][c1][c2] =  max cherries that can be collected till (row, c1) by robot1 and (row, c2) by robot2
        dp[0][0][cols-1]=grid[0][0]+grid[0][cols-1];//no check as cols>1

        for(int i=1;i<rows;i++){
            for(int c1=0;c1<=Math.min(i,cols-1);c1++){
                for(int c2=Math.max(0,cols-1-i);c2<cols;c2++){

                    int prev=0;
                    for(int prevCol1=Math.max(0,c1-1);prevCol1<=Math.min(cols-1,c1+1);prevCol1++){
                        for(int prevCol2=Math.max(0,c2-1);prevCol2<=Math.min(cols-1,c2+1);prevCol2++){
                            prev=Math.max(prev,dp[i-1][prevCol1][prevCol2]);
                        }
                    }
                    dp[i][c1][c2]=prev+grid[i][c1];
                    if(c1!=c2) dp[i][c1][c2]+=grid[i][c2];
                }
            }
        }
        int ans=0;
        for(int i=0;i<cols;i++){
            for(int j=0;j<cols;j++){
                ans=Math.max(ans,dp[rows-1][i][j]);
            }
        }
        return ans;
    }
    private int solve(int[][] grid,int row,int col1,int col2,int[][][] dp){
        if(row==grid.length) return 0;

        if(dp[row][col1][col2]!=-1) return dp[row][col1][col2];

        int ans=grid[row][col1];
        if(col1!=col2){
            ans+=grid[row][col2];
        }
        int[] delCol={-1,0,1};
        int max=0;
        for(int x : delCol){
            for(int y : delCol){
                int newC1=col1+x;
                int newC2=col2+y;
                if(newC1>=0 && newC1<grid[0].length && newC2>=0 && newC2<grid[0].length){
                    max=Math.max(max,solve(grid,row+1,newC1,newC2,dp));
                }
            }
        }
        return dp[row][col1][col2]=ans+max;
    }
}
