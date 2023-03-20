package Backtracking;

public class Sudoku {
    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        //base case
        if (row == 9) {//all elements filled
            return true;
        }
        //recursion
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        //if elements exist
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    //solution exist
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        //element not in column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        //element not in row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }
        //element not in grid
        int sr = (row / 3) * 3;//starting row of grid
        int sc = (col / 3) * 3;//starting col of grid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void printSudoku(int[][] sudoku){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void solveSudoku(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isSafe(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board)) return true;
                            board[i][j]='.';
                        }
                    }
                    return false; // move the statement outside of the loop->after checking all cells
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][] board, int row, int col, char digit) {
        //element not in column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] ==digit) {
                return false;
            }
        }
        //element not in row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }
        //element not in grid
        int sr = (row / 3) * 3;//starting row of grid
        int sc = (col / 3) * 3;//starting col of grid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] ==digit) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] sudoku = {{0, 0, 8, 0, 0, 0, 0, 0, 0},
                {4, 9, 0, 1, 5, 7, 0, 0, 2},
                {0, 0, 3, 0, 0, 4, 1, 9, 0},
                {1, 8, 5, 0, 6, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 0, 0, 6, 0},
                {9, 6, 0, 4, 0, 5, 3, 0, 0},
                {0, 3, 0, 0, 7, 2, 0, 0, 4},
                {0, 4, 9, 0, 3, 0, 0, 5, 7},
                {8, 2, 7, 0, 0, 9, 0, 1, 3}};
        if(sudokuSolver(sudoku,0,0)){
            System.out.println("solution exists");
            printSudoku(sudoku);
        }
        else{
            System.out.println("no solution");
        }
    }
}


