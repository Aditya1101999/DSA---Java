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
}
