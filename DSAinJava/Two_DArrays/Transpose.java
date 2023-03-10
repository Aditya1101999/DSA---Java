package Two_DArrays;

public class Transpose {
    public static void print_matrix(int matrix[][]) {
        System.out.println("The matrix is :");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");


            }

            System.out.println();
        }
    }

    public static void main(String args[]) {
        int row = 2, column = 3;
        int[][] matrix = {{2, 3, 7}, {5, 6, 7}};
        //display original matrix
        print_matrix(matrix);
        //transpose matrix
        int[][] transpose = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //interchanging values
                transpose[j][i] = matrix[i][j];
            }

        }
        print_matrix(transpose);
    }
}
