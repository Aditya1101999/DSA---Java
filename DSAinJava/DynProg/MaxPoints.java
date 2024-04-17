package DSAinJava.DynProg;
import java.util.*;
public class MaxPoints {
    public long maxPoints(int n, int[][] arr) {
        long[] dp=new long[n];
        Arrays.fill(dp,-1);
        return solve(arr,0,dp);
    }
    private long solve(int[][] arr,int index,long[] dp){
        if(index>=arr.length) return 0;

        if(dp[index]!=-1) return dp[index];
        long include=arr[index][0]+solve(arr,index+arr[index][1]+1,dp);
        long exclude=solve(arr,index+1,dp);

        return dp[index]=Math.max(include,exclude);
    }
}
