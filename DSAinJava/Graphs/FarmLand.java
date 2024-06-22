package DSAinJava.Graphs;
import java.util.*;
public class FarmLand {
    public List<int []> findFarmland(int[][] land) {
        int m=land.length;
        int n=land[0].length;
        List<int[]>ans=new ArrayList<>();
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==1 && !visited[i][j]){
                    int r2=i;
                    int c2=j;
                    for(r2=i;r2<m && land[r2][j]==1 && !visited[r2][j];r2++){//down
                        for(c2=j;c2<n && land[r2][c2]==1 && !visited[r2][c2];c2++){//right
                            visited[r2][c2]=true;
                        }
                    }
                    int[] group={i,j,r2-1,c2-1};
                    ans.add(group);
                }
            }
        }
        return ans;
    }
}
