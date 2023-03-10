package sorting;

public class bubblesort {
    public static void bubble_sort(int arr[]){
        boolean swapped=false;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                //(arr[j] < arr[j+1]) for descending array
                if (arr[j] > arr[j+1]) {
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            //modified bubble sort
            if(swapped==false){
                System.out.println("already sorted");
                break;
            }
        }
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String args[]){
        int arr[]={5,4,1,3,2};
        bubble_sort(arr);
        printarr(arr);
    }
}
