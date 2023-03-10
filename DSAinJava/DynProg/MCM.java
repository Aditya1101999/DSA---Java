package DynProg;
import java.util.*;
public class MCM {
    public static int mincost(int[] arr,int i,int j){
        if(i==j){//single matrix
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=mincost(arr, i, k);//Ai...Ak=>arr[i-1]x arr[k]
            int cost2=mincost(arr,k+1,j);//Ak+1...Aj=>arr[k]x arr[j]
            int cost3=arr[i-1]*arr[k]*arr[j];//a*b*c
            int finalCost=cost1+cost2+cost3;
            ans=Math.min(ans,finalCost);
        }
        return ans;
    }
    public static int memo(int[] arr,int i,int j,int[][] dp){
        if(i==j){//single matrix
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=memo(arr, i, k,dp);//Ai...Ak=>arr[i-1]x arr[k]
            int cost2=memo(arr,k+1,j,dp);//Ak+1...Aj=>arr[k]x arr[j]
            int cost3=arr[i-1]*arr[k]*arr[j];//a*b*c
            int finalCost=cost1+cost2+cost3;
            ans=Math.min(ans,finalCost);
            dp[i][j]=ans;
        }
        return dp[i][j];
    }
    public static int tab(int[] arr){
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){//initialization
            dp[i][i]=0;//single matrix
        }
        for(int length=2;length<n;length++){//total matrices
            for(int i=1;i<=n-length;i++){//row
                int j=i+length-1;//column
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    int finalCost=cost1+cost2+cost3;
                    dp[i][j]=Math.min(dp[i][j],finalCost);
                }
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,3};
        int n= arr.length;
        System.out.println(mincost(arr,1, n-1));
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(memo(arr,1,n-1,dp));
        System.out.println(tab(arr));
    }
}
