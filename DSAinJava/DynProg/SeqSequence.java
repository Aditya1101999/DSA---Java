package DSAinJava.DynProg;

public class SeqSequence {
    static int numberSequence(int m, int n) {
        // if(m<n) return 0;
        // if(n==1) return m;
        // return numberSequence(m/2,n-1)+numberSequence(m-1,n);
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][1]=i;
        }
        for(int i=1;i<m+1;i++){
            for(int j=2;j<n+1;j++){
                dp[i][j]=dp[i/2][j-1]+dp[i-1][j];
            }
        }
        return dp[m][n];
    }
//    static int numberSequence(int m, int n) {
//         if(m<n) return 0;
//         if(n==0) return 1;
//         return numberSequence(m/2,n-1)+numberSequence(m-1,n);
//        int[][] dp=new int[m+1][n+1];
//        for(int i=0;i<m+1;i++){
//            dp[i][0]=1;
//        }
//        for(int i=1;i<m+1;i++){
//            for(int j=1;j<n+1;j++){
//                dp[i][j]=dp[i/2][j-1]+dp[i-1][j];
//            }
//        }
//        return dp[m][n];
//    }

}
