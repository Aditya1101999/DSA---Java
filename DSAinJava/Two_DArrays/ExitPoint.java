package DSAinJava.Two_DArrays;

public class ExitPoint {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        int x=0;
        int y=0;
        int dir=0;
        //0->east , 1->south , 2-> west , 3-> north
        while(true){
            dir = (dir + matrix[x][y]) % 4;
            if(matrix[x][y]==1) matrix[x][y]=0;
            if (dir == 0) {
                if (y + 1 < m) {
                    y++;
                } else {
                    break;
                }
            } else if (dir == 1) {
                if (x + 1 < n) {
                    x++;
                } else {
                    break;
                }
            } else if (dir == 2) {
                if (y - 1 >= 0) {
                    y--;
                } else {
                    break;
                }
            } else {
                if (x - 1 >= 0) {
                    x--;
                } else {
                    break;
                }
            }
        }
        return new int[]{x,y};
    }
}
