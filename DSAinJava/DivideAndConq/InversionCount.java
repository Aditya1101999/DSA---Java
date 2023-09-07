package DivideAndConq;
public class InversionCount {
    public static int mergeSort(int arr[],int si,int ei){
        int invCount=0;
        if(si<ei) {
            int mid = si + (ei - si) / 2;//to avoid overflow
            invCount = mergeSort(arr, si, mid);//left
            invCount += mergeSort(arr, mid + 1, ei);//right
            invCount += merge(arr, si, mid + 1, ei);
        }
        return invCount;
    }
    public static int merge(int[] arr,int si,int mid,int ei) {
        int[] temp = new int[ei - si + 1];
        //iterators
        int i = si;//for left part
        int j = mid;//for right part
        int k = 0;//for mp array
        int invCount = 0;
        while (i < mid && j <= ei) {
            //left array
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            }
            //right array
            else {
                temp[k] = arr[j];
                invCount += (mid - i+1);
                j++;
                k++;
            }
        }
        //for leftover elements in left part
        while (i < mid) {
            temp[k++] = arr[i++];//combined i++ and k++
        }
        //for leftover elements in right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        //copy temp array to original array
        for (k = 0, i = si; i<=ei; k++, i++) {
            arr[i] = temp[k];
        }
        return invCount;
    }
    public static void main(String args[]){
        int arr[]={2,4,1,3,5};
        System.out.println(mergeSort(arr,0, arr.length-1));
    }
}

