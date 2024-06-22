package DSAinJava.arrays;

public class ExtraEl {
    public int findExtra(int n, int arr1[], int arr2[]) {
        int low=0;
        int high=n-2;
        int index=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr1[mid]==arr2[mid]){
                low=mid+1;
            }
            else{
                index=mid;
                high=mid-1;
            }
        }
        return index;
    }
}
