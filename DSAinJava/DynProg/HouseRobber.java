package DynProg;

public class HouseRobber {
    public static int Robber1(int[] arr){
        int n=arr.length;
        if(n==0){
            return 0;
        }
        else if(n==1){
            return arr[0];
        }
        else if(n==2){
            return Math.max(arr[0],arr[1]);
        }
        int[] dp=new int[n];
        dp[0]=arr[0];
        dp[1]=arr[1];
        dp[2]=arr[0]+arr[2];
        int max=Math.max(dp[2],dp[1]);
        for(int i=3;i<n;i++){
            dp[i]=Math.max(dp[i-3],dp[i-2])+arr[i];
            max=Math.max(dp[i],max);
        }
        return max;
    }
    public static int HouseRobber2(int[] arr){
        int n=arr.length;
        if(n==0){
            return 0;
        }
        else if(n==1){
            return arr[0];
        }
        else if(n==2){
            return Math.max(arr[0],arr[1]);
        }
        return Math.max(Helper(arr,0,n-1),Helper(arr,1,n));
    }
    private static int Helper(int[] arr,int start,int end){
        int prev=0;//2 indices before
        int curr=0;//1 index before
        int max=0;
        for(int i=start;i<end;i++){
            max=Math.max(prev+arr[i],curr);
            prev=curr;//now curr is 2 indices before
            curr=max;//max is maximum till 1 index before
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = {2,3,2};
        System.out.println(HouseRobber2(nums));
        System.out.println(Robber1(nums));

    }
}

