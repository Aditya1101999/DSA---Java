package DivideAndConq;
public class MergeSortString {
    public static String[] mergeSort(String[] arr,int si,int ei){
        //base case
        if(si==ei){//single element
            String[] a={arr[si]};
            return a;
        }
        int mid=si+(ei-si)/2;//to avoid overflow
        String[] arr1=mergeSort(arr, si, mid);//left
        String[] arr2=mergeSort(arr, mid+1, ei);//right
        String[] arr3=merge(arr1,arr2);
        return arr3;
    }
    public static String[] merge(String[] arr1,String[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        String[] arr3 = new String[m + n];

        int k = 0;

        int i = 0, j = 0;

        while (i < m && j < n) {
            //left array
            if (isAlphabeticallySmaller(arr1[i], arr2[j])) {
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            //right array
            else {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }
        //for leftover elements in left part
        while (i <m) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }
        //for leftover elements in right part
        while (j < n) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }
        return arr3;
    }
    public static boolean isAlphabeticallySmaller(String str1,String str2) {
        if (str1.compareTo(str2) < 0) {
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        String[] arr={"sun","mars","earth","mercury"};
        String[] a=mergeSort(arr,0, arr.length-1);
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
    }
}

