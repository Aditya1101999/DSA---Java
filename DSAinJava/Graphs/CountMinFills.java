package DSAinJava.Graphs;

public class CountMinFills {
    public int minFills(char[][] board){//a,b,c etc.
        int count=0;
        int n=board.length;
        int m=board[0].length;
        char newColor='p';
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char color=board[i][j];
                if(color!=newColor){
                    dfs(board,i,j,n,m,newColor,color);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] board,int i,int j,int n,int m,char newColor,char color){
        if(i>=0 && j>=0 && i<n && j<m && board[i][j]==color) {
            board[i][j]=newColor;
        }
        dfs(board,i+1,j,n,m,newColor,color);
        dfs(board,i-1,j,n,m,newColor,color);
        dfs(board,i,j+1,n,m,newColor,color);
        dfs(board,i,j-1,n,m,newColor,color);
    }
}
