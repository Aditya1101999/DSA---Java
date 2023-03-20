package DSAinJava.Backtracking;
import java.util.*;
public class NQueens {
    static int count=0;//no. of solutions
    public static void nQueens(char board[][], int row) {
        //base condition
        if (row == board.length) {
            printBoard(board);
            // below only for modified questions
            count++;
            //return true;
        }
        //column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board,row+1);//function call
                /*
                //for checking if solution available
                if(nQueens(board,row+1)){
                return true
                else false
                 */
                board[row][j] = 'X';//backtracking step
            }
        }
    }
    public static boolean isSafe(char board[][],int row,int col) {
        //vertically up,i.e.same column but row decreasing
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //diagonally left
        for (int i = row - 1,j=col-1;i>=0 && j>=0;i--,j--) {
            if (board[i][j] == 'Q') {
                    return false;
            }
        }
        //diagonally right
        for (int i = row - 1,j=col+1; i >= 0 && j< board.length; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]) {
        System.out.println("---------chess board--------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public List<List<String>> solveNQueens(int n) {//leetcode 51
        List<List<String>>ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';//initialize with empty square
            }
        }
        placeQueens(0,ans,board);
        return ans;
    }
    private void placeQueens(int row,List<List<String>> ans,char[][] board){
        if(row==board.length){
            ans.add(build(board));
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isValid(board,row,col)){
                board[row][col]='Q';
                placeQueens(row+1,ans,board);
                board[row][col]='.';
            }
        }
    }
    private boolean isValid(char[][] board,int row,int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    private List<String> build(char[][] board){
        List<String>curr=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            curr.add(new String(board[i]));
        }
        return curr;
    }
    public int totalNQueens(int n) {//counting solutions
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';//initialize with empty square
            }
        }
        return placeQueens(0,board);
    }
    private int placeQueens(int row,char[][] board){
        if(row==board.length){
            return 1;
        }
        int count=0;
        for(int col=0;col<board.length;col++){
            if(isValid(board,row,col)){
                board[row][col]='Q';
                count+=placeQueens(row+1,board);
                board[row][col]='.';
            }
        }
        return count;
    }
    public static void main(String args[]) {
        int n = 8;
        char board[][] = new char[n][n];
        //inititalize
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                board[i][j] = 'X';
            }
        }
        nQueens(board,0);
        System.out.println("total solutions are "+count);
        /*if(nQueens(board,0)){
        print solution possible
         */

    }
}
