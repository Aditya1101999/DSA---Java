package sorting;

public class Countsort {
    public static void counting_sort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(arr[i], largest);
        }
        int count[] = new int[largest + 1];
        for (int i = 0; i <arr.length; i++) {
            count[arr[i]]++;
        }
        //sorting
        int j = 0;
        /*for (int i = count.length-1; i >=0; i--) {
        for decreasing order array
         */
        for (int i = 0; i < count.length; i++)
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }

    public static void main(String args[]){
        int arr[]={1,4,1,3,2,4,3,7};
        counting_sort(arr);
        printarr(arr);
    }
}


