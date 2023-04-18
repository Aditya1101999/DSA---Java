package DSAinJava.Graphs;
import java.util.*;
public class Waterflow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>ans=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        if(n == 0) return ans;

        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int j=0;j<n;j++){//for each column
            dfs(0,j,pacific,heights,0);//first row

            dfs(m-1,j,atlantic,heights,0);//last row
        }
        for(int i=0;i<m;i++){//for each row
            dfs(i,0,pacific,heights,0);//first column

            dfs(i,n-1,atlantic,heights,0);//last column
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    private void dfs(int i, int j, boolean[][] canReach, int[][] matrix, int prevHeight){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || canReach[i][j] ||
                matrix[i][j] <prevHeight){//we are coming from ocean , so currHeight  needs to be greater than prevHeight so that water can flow into ocean
            return;
        }

        canReach[i][j] = true;

        dfs(i+1, j, canReach, matrix, matrix[i][j]);
        dfs(i-1, j, canReach, matrix, matrix[i][j]);
        dfs(i, j-1, canReach, matrix, matrix[i][j]);
        dfs(i, j+1, canReach, matrix, matrix[i][j]);

    }
}
