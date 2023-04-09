package DSAinJava.Graphs;

public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    maxArea=Math.max(maxArea,getAreaDFS(i,j,grid,visited));
                }
            }
        }
        return maxArea;
    }
    private int getAreaDFS(int row,int col,int[][] grid,boolean[][] visited){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length ||
                visited[row][col] || grid[row][col]==0){
            return 0;
        }
        visited[row][col]=true;
        int leftArea=getAreaDFS(row,col-1,grid,visited);
        int rightArea=getAreaDFS(row,col+1,grid,visited);
        int topArea=getAreaDFS(row-1,col,grid,visited);
        int bottomArea=getAreaDFS(row+1,col,grid,visited);

        int totalArea=leftArea+rightArea+topArea+bottomArea;
        return 1+totalArea;//self
    }
}
