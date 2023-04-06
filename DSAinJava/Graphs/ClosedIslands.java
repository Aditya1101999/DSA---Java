package DSAinJava.Graphs;

public class ClosedIslands {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && dfs(grid,i,j)) count++;
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid,int row,int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length) return false;

        if(grid[row][col]==1) return true;//visited or closed

        grid[row][col]=1;//visited
        boolean up=dfs(grid,row-1,col);
        boolean down=dfs(grid,row+1,col);
        boolean left=dfs(grid,row,col-1);
        boolean right=dfs(grid,row,col+1);

        return up && down && left && right;
    }
}
