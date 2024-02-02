package DSAinJava.Graphs;

public class DisconnectIsland {
    public int minDays(int[][] grid) {
        //case 1-> 0 days required
        if(disConnected(grid)) return 0;
        //case 2-> 1 days required(just remove 1 cell)
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(disConnected(grid)) return 1;
                    grid[i][j]=1;
                }
            }
        }
        //case 2-> corner case
        return 2;
    }
    private boolean disConnected(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;

        int islands=0;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    dfs(grid,visited,i,j,m,n);
                    islands++;
                    if(islands>1) return true;
                }
            }
        }
        return islands==0;
    }
    private void dfs(int[][] grid,boolean[][] visited, int i, int j,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || grid[i][j]==0) return;

        visited[i][j]=true;
        dfs(grid,visited,i+1,j,m,n);
        dfs(grid,visited,i,j+1,m,n);
        dfs(grid,visited,i-1,j,m,n);
        dfs(grid,visited,i,j-1,m,n);
    }
}
