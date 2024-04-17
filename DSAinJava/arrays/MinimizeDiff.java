package DSAinJava.arrays;

public class MinimizeDiff {
    public static int minimizeDifference(int n, int k, int[] arr) {
        int[] rightmax=new int[n];
        int[] rightmin=new int[n];
        rightmax[n-1]=arr[n-1];
        rightmin[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(arr[i],rightmax[i+1]);
            rightmin[i]=Math.min(arr[i],rightmin[i+1]);
        }
        //left part is empty
        int diff=rightmax[k]-rightmin[k];
        int leftmin=arr[0];
        int leftmax=arr[0];
        for(int i=1;i<n-k;i++){
            int maxInRemainingArr=Math.max(leftmax,rightmax[i+k]);
            int minInRemainingArr=Math.min(leftmin,rightmin[i+k]);
            diff=Math.min(diff,maxInRemainingArr-minInRemainingArr);

            leftmin=Math.min(leftmin,arr[i]);
            leftmax=Math.max(leftmax,arr[i]);
        }
        //right part is empty
        diff=Math.min(diff,leftmax-leftmin);
        return diff;

    }
}
