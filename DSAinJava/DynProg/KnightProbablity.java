package DSAinJava.DynProg;

public class KnightProbablity {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp=new double[k+1][n][n];
        dp[0][row][column]=1.0;
        int[] delRow={-2,-2,-1,1,2,2,1,-1};
        int[] delCol={-1,1,2,2,1,-1,-2,-2};
        for(int moves=1;moves<=k;moves++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int dir=0;dir<8;dir++){
                        int nrow=i+delRow[dir];
                        int ncol=j+delCol[dir];
                        if(nrow>=0 && ncol>=0 && nrow<n && ncol<n){
                            dp[moves][i][j]+=dp[moves-1][nrow][ncol]*0.125;
                        }
                    }
                }
            }
        }
        double res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res+=dp[k][i][j];
            }
        }
        return res;
    }
    private int[][]dir = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    private double[][][] dp;
    public double knightProbabilitymemo(int N, int K, int r, int c) {
        dp = new double[N][N][K + 1];
        return find(N,K,r,c);
    }
    public double find(int N,int K,int r,int c){
        if(r < 0 || r > N - 1 || c < 0 || c > N - 1) return 0;
        if(K == 0)  return 1;
        if(dp[r][c][K] != 0) return dp[r][c][K];
        double rate = 0;
        for(int i = 0;i < dir.length;i++)
            rate += 0.125 * find(N,K - 1,r + dir[i][0],c + dir[i][1]);
        dp[r][c][K] = rate;
        return rate;
    }
}
