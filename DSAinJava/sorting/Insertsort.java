package sorting;

public class Insertsort {
    public static void insertion_sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            //finding out correct position
            while(prev>=0 && arr[prev]>curr){
                //arr[prev]<curr for descending order
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1]=curr;
        }
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }

    public static void main(String args[]){
        int arr[]={5,4,1,3,2};
        insertion_sort(arr);
        printarr(arr);
    }
}



