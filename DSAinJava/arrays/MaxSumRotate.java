package DSAinJava.arrays;

public class MaxSumRotate {
    int max_sum(int[] A, int n) {
        int sum=0;
        int currConfigSum=0;

        for(int i=0;i<n;i++){
            sum+=A[i];
            currConfigSum+=i*A[i];
        }
        int maxSum=currConfigSum;
        //Si=S(i-1)+sum-n*arr[n-1-i]//last term
        for(int i=0;i<n-1;i++){//after n times we will get the same array back
            int newSum=currConfigSum+sum-n*A[n-1-i];
            maxSum=Math.max(maxSum,newSum);
            currConfigSum=newSum;
        }
        return maxSum;
    }
}
