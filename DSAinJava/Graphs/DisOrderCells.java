package DSAinJava.Graphs;
import java.util.*;
public class DisOrderCells {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] matrix=new int[rows*cols][2];
        Queue<int[]>q=new LinkedList<>();
        boolean[][] visited=new boolean[rows][cols];
        q.add(new int[]{rCenter,cCenter});
        visited[rCenter][cCenter]=true;
        int index=0;
        int[] dRow={0,-1,0,1};
        int[] dCol={-1,0,1,0};
        while(!q.isEmpty()){
            int row=q.peek()[0];
            int col=q.peek()[1];
            q.poll();
            matrix[index++]=new int[]{row,col};

            for(int i=0;i<4;i++){
                int delRow=row+dRow[i];
                int delCol=col+dCol[i];

                if(delRow>=0 && delRow<rows && delCol>=0 && delCol<cols &&
                        !visited[delRow][delCol]){
                    visited[delRow][delCol]=true;
                    q.add(new int[]{delRow,delCol});
                }
            }
        }
        return matrix;
    }
}
