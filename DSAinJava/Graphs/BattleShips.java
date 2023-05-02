package DSAinJava.Graphs;

public class BattleShips {
    public int countBattleships(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int count=0;
        if(m==0||n==0) return 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){//no adjacent ships to that ship
                if(board[i][j]=='X' && (i==0||board[i-1][j]=='.') && (j==0||board[i][j-1]=='.')){
                    count++;
                }
            }
        }
        return count;
    }
}
