package Heaps;
public class HeapSort {
    public static void heapSort(int[] arr){
        //build maxheap
        int n=arr.length;
        //In the case of a complete tree, the first index of a non-leaf node is
        // given by n/2 - 1. All
        // other nodes after that are leaf-nodes and thus don't need to be heapified.
        for(int i=n/2;i>=0;i--){
            heapify(i,n,arr);
        }
        //push largest at end
        for(int i=n-1;i>0;i--){
            //swap first with last
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(0,i,arr);
        }
    }
    public static void heapify(int i,int size,int arr[]){
        int left=2*i+1;
        int right=2*i+2;
        int max=i;
        if(left<size && arr[left]>arr[max]){
            max=left;
        }
        if(right<size && arr[right]>arr[max]){
            max=right;
        }
        if(max!=i){
            //swap
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;

            heapify(max,size,arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 3};
        heapSort(arr);
        for (int i=0;i< arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
