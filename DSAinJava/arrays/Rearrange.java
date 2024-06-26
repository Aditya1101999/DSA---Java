package DSAinJava.arrays;

public class Rearrange {
    public static int[] RearrangeArray(int[] arr, int n) {
        int i=0;
        while(i<n){
            if(arr[i]>=0 && arr[i]!=i){
                int correctIndex=arr[i];
                int temp=arr[correctIndex];
                arr[correctIndex]=arr[i];
                arr[i]=temp;
            }
            else{
                i++;
            }
        }
        return arr;
    }
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int pos=0;
        int neg=1;
        for(int el : nums){
            if(el>0){
                ans[pos]=el;
                pos+=2;
            }
            else{
                ans[neg]=el;
                neg+=2;
            }
        }
        return ans;
    }
}
