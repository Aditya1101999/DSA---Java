package arrays;

public class SecondLargest {
    public static int SecondLargest(int n,int[] arr){
        int max=arr[0];
        int secMax=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                secMax=max;
                max=arr[i];
            }
            else if(max>arr[i] && arr[i]>secMax){
                secMax=arr[i];
            }
        }
        return secMax;
    }
}
