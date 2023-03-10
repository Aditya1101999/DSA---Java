package DynProg;

public class EggDrop {
    public int superEggDrop(int k, int n) {
        int[][] dp=new int[k+1][n+1];
        return Helper(k,n,dp);
    }
    private int Helper(int eggs,int floors,int[][] dp){
        if(floors==0||floors==1){
            return floors;
        }
        if(eggs==1){
            return floors;
        }
        if(dp[eggs][floors]!=0){
            return dp[eggs][floors];
        }
        int min=Integer.MAX_VALUE;
        // for(int i=1;i<floors+1;i++){
        //     int curr=1+Math.max(Helper(eggs-1,i-1,dp),Helper(eggs,floors-i,dp));
        //     min=Math.min(curr,min);
        // }
        int low=1;
        int high=floors;
        while(low<high){
            int mid=low+(high-low)/2;
            int left=Helper(eggs-1,mid-1,dp);//break
            int right=Helper(eggs,floors-mid,dp);//not break
            min=Math.min(min,Math.max(left,right)+1);
            if(left<right){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return dp[eggs][floors]=min;
    }
}
