package DSAinJava.DynProg;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return mat;
        }

        int rows = mat.length;
        int cols = mat[0].length;
        if (rows == 1 && cols == 1) {
            return mat;
        }

        int[][] result = new int[rows][cols];
        // (rows + cols - 1) is the maximum possible distance in the matrix. Its the
        // distance been two diagonally opposite corners.
        int maxDistance = rows + cols;

        for (int i = 0; i < rows; i++) {//pass 1
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    result[i][j]=0;
                }
                result[i][j] = maxDistance;
                if (i > 0) {//down rows
                    result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                }
                if (j > 0) {//right cols
                    result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {//pass 2
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    result[i][j]=0;
                }
                if (i < rows - 1) {//up rows
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                }
                if (j < cols - 1) {//left cols
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }
            }
        }

        return result;
    }
}
