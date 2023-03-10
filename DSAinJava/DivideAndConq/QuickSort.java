package DivideAndConq;

public class QuickSort {
    public static void quickSort(int arr[],int si,int ei){
        //base case
        if(si>=ei){//single element
            return;
        }
        //pivot=last element
        //partition
        int pidx=partition(arr,si,ei);
        quickSort(arr, si, pidx-1);//left
        quickSort(arr,pidx+1,ei);//right
    }
    public static int partition(int arr[],int si,int ei){
        int pivot=arr[ei];
        //taking last element as pivot
        int i=si-1;//to make place for smaller elements
        for(int j=si;j<ei;j++) {
            if (arr[j] <= pivot) {
                //swap
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
            //for pivot
        i++;
        int temp=pivot;
        arr[ei]=arr[i];//pivot==arr[ei] can't be written,
        arr[i]=temp;//since pivot is a variable
        return i;
    }

    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[]={6,3,9,5,2,8,-1};
        quickSort(arr,0, arr.length-1);
        printarr(arr);
    }
}
