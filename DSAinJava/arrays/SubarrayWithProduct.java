package arrays;

public class SubarrayWithProduct {
    public static int subarrayProduct(int[] arr,int k){
        int n=arr.length;
        int start=0;
        int end=0;
        int res=0;
        int product=1;
        int countOnes=0;
        while(end<n){//cal all subarrays
            product*=arr[end];
            if(product>k){//increment start
                while(start<end&&product>k) {
                    product /= arr[start];
                    start++;
                }
            }
            if(product==k){
                while(end+1<n&&arr[end+1]==1) {//succeeding ones after subarray
                    countOnes++;
                    end++;
                }
                res+=(countOnes+1);//+1 for the subarray from window
                while(start<=end&&arr[start]==1){//counting ones from start
                    res+=(countOnes+1);
                    start++;
                }
                product/=arr[start];
                start++;
            }
            end++;
        }
        return res;
    }
    public int maxProduct(int[] nums) {
        int product=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            product*=nums[i];
            max=Math.max(max,product);
            if(product==0) product=1;
        }
        product=1;
        for(int i=nums.length-1;i>=0;i--){
            product*=nums[i];
            max=Math.max(max,product);
            if(product==0) product=1;
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = {2, 1, 1, 1, 4, 5};
        int k = 4;
        System.out.println(subarrayProduct(arr,k));
    }
}
