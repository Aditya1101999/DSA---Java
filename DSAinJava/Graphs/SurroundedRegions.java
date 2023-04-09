package DSAinJava.Graphs;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){//boundary traversals
            for(int j=0;j<n;j++){
                if(!visited[i][0] && board[i][0]=='O'){//first column
                    dfs(i,0,board,visited);
                }
                if(!visited[0][j] && board[0][j]=='O'){//first row
                    dfs(0,j,board,visited);
                }
                if(!visited[i][n-1] && board[i][n-1]=='O'){//last column
                    dfs(i,n-1,board,visited);
                }
                if(!visited[m-1][j] && board[m-1][j]=='O'){//last row
                    dfs(m-1,j,board,visited);
                }
            }
        }
        for(int i=0;i<m;i++){//capturing the unvisited cells
            for(int j=0;j<n;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(int row,int col,char[][] board,boolean[][] visited){
        visited[row][col]=true;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && ncol>=0 && nrow<board.length && ncol<board[0].length &&
                    !visited[nrow][ncol] && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,board,visited);
            }
        }
    }
}
