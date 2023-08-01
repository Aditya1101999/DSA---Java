package DSAinJava.DynProg;

public class StrangePrinter {
    public int strangePrinter(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        return solvePrinter(s,0,n-1,dp);
    }
    private int solvePrinter(String s,int i,int j,int[][] dp){
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int minTurns=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int currTurns=solvePrinter(s,i,k,dp)+solvePrinter(s,k+1,j,dp);
            minTurns=Math.min(minTurns,currTurns);
        }//original characters can be replaced, so reducing one turn ,e.g. -> aaa->aba(2 moves)
        return dp[i][j]=s.charAt(i)==s.charAt(j)?minTurns-1:minTurns;
    }
}
