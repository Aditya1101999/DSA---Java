package DSAinJava.Graphs;

public class MaximumGold {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int gold=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){//have some gold
                    gold=Math.max(gold,dfs(grid,i,j));
                }
            }
        }
        return gold;
    }
    private int dfs(int[][] grid,int row,int col){
        int goldValue=grid[row][col];
        grid[row][col]=0;//visited
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        int maxValue=0;
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]!=0){
                maxValue=Math.max(maxValue,dfs(grid,nrow,ncol));
            }
        }
        grid[row][col]=goldValue;//backtrack
        return goldValue+maxValue;
    }
}
