package DSAinJava.Graphs;
import java.util.*;
public class RottenOranges {
    static class Pair {
        int row;
        int col;
        int time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {//rotten oranges
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                if (grid[i][j] == 1) {//count of fresh oranges
                    fresh++;
                }
            }
        }
        int tm = 0;
        int[] row = {-1, 0, 1, 0};//row directions
        int[] col = {0, 1, 0, -1};//col directions
        int count = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            tm = Math.max(tm, t);
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = r + row[i];
                int ncol = c + col[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    //fresh orange
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        if (count != fresh) {//all oranges not rotten
            return -1;
        }
        return tm;
    }
    public static void main(String[] args){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
