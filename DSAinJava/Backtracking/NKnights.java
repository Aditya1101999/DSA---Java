package Backtracking;

public class NKnights {
    public static void printBoard(int[][] board) {
        System.out.println("---------chess board--------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void knightTour(int[][] chess,int r,int c,int move){
        //base case
        if(r<0||c<0 ||r>=chess.length||c>=chess.length
        ||chess[r][c]>0) {
            return;
        }
        //last case
        if (move == (chess.length * chess.length)-1) {
            chess[r][c]=move;
            printBoard(chess);
            return;
        }
        chess[r][c]=move;
        //all possible moves
        knightTour(chess,r+2,c+1,move+1);
        knightTour(chess,r+1,c+2,move+1);
        knightTour(chess,r-1,c+2,move+1);
        knightTour(chess,r-2,c+1,move+1);
        knightTour(chess,r-2,c-1,move+1);
        knightTour(chess,r-1,c-2,move+1);
        knightTour(chess,r+1,c-2,move+1);
        knightTour(chess,r+2,c-1,move+1);
        chess[r][c]=0;//backtracking step
    }

    public static void main(String[] args) {
        int[][] chess = new int[8][8];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = 0;
            }
        }
        knightTour(chess, 0,0, 0);
    }
}
