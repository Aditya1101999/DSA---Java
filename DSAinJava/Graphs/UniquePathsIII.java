package Graphs;

public class UniquePathsIII {
    public static int uniquePathsIII(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;//stores zero
        int sx=0;//starting x index
        int sy=0;//starting y index

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    count++;
                }
                else if(grid[i][j]==1){
                    sx=i;
                    sy=j;
                }
            }
        }
        return dfs(grid,sx,sy,count);
    }
    public static int dfs(int[][] grid,int x,int y,int count){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==-1){
            return 0;
        }
        if(grid[x][y]==2){//ending square
            return count== -1 ? 1 : 0;//-1 coz when we reach final cell we are covering one cell extra than zero count
        }
        grid[x][y]=-1;//mark visited cells as -1
        count--;
        //calculating all paths in 4 directions
        int totalPaths=dfs(grid,x+1,y,count)+
                dfs(grid,x-1,y,count)+
                dfs(grid,x,y+1,count)+
                dfs(grid,x,y-1,count);
        grid[x][y]=0;//backtrack
        count++;

        return totalPaths;
    }
    public static void main(String[] args){
        int[][] grid={{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(uniquePathsIII(grid));

    }
}
