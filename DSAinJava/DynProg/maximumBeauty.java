package DSAinJava.DynProg;
import java.util.Arrays;
public class maximumBeauty {
    long maxBeauty(int n, int k, int[] flowers)
    {
        long[][] dp=new long[n+1][k+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxmimumBeautyHelper(0,0,k,flowers,n,dp);
    }
    private long maxmimumBeautyHelper(int index,int count,int k,int[] flowers,int n,long [][] dp){
        if(index>=n){
            if(count==k) return 0;
            return Long.MIN_VALUE;
        }
        if(count==k) return 0;
        if(dp[index][count]!=-1){
            return dp[index][count];
        }
        long pick=flowers[index]+maxmimumBeautyHelper(index+2,count+1,k,flowers,n,dp);
        long notPick=maxmimumBeautyHelper(index+1,count,k,flowers,n,dp);
        return dp[index][count]=Math.max(pick,notPick);
    }
}
