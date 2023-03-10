package Graphs;
import java.util.*;
public class DistinctIslands {
    public static int distinctIslands(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        HashSet<ArrayList<String>>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] &&grid[i][j]==1){
                    ArrayList<String>arr=new ArrayList<>();
                    dfs(i,j,visited,grid,arr,i,j);
                    set.add(arr);
                }
            }
        }
        return set.size();
    }
    private static String toString(int r,int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    private static void dfs(int row,int col,boolean[][] visited,int[][] grid,ArrayList<String>arr,
                            int row0,int col0){//base row and base col
        visited[row][col]=true;
        arr.add(toString(row-row0,col-col0));
        int n=grid.length;
        int m=grid[0].length;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0&&ncol>=0&&nrow<n&&ncol<m&&!visited[nrow][ncol]&&grid[nrow][ncol]==1){
                dfs(nrow,ncol,visited,grid,arr,row0,col0);
            }
        }
    }
    public static void main(String[] args){
        int grid[][] = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        System.out.println(distinctIslands(grid));
    }
}
