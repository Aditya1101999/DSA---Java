package DynProg;

public class MinPart {
    public static int tab(int[] arr){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int S=sum/2;
        int[][] dp=new int[n+1][S+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<S+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<S+1;j++){
                int val=arr[i-1];
                if(val<=j){//valid case

                    int inc=val+dp[i-1][j-val];
                    int exc=dp[i-1][j];
                    dp[i][j]=Math.max(inc,exc);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sum1= dp[n][S];
        int sum2=sum-sum1;
        System.out.println(sum1+" "+sum2);
        return Math.abs(sum2-sum1);
    }
    public static void main(String[] args){
        int[] arr={1,6,11,5};
        System.out.println(tab(arr));
    }
}
