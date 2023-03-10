package sorting;
public class Selectsort{
    public static void selection_sort(int arr[]){
    for(int i=0;i<arr.length-1;i++){
        int minPos=i;
        //i+1 is the start of unsorted array
        for(int j=i+1;j<arr.length;j++){
            //arr[minPos]<arr[j]) for descending array
            if (arr[minPos]>arr[j]){
                minPos=j;
            }
        }
        //swap
        int temp=arr[minPos];
        arr[minPos]=arr[i];
        arr[i]=temp;


        }
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }

    public static void main(String args[]){
        int arr[]={5,4,1,3,2};
        selection_sort(arr);
        printarr(arr);
    }
}



