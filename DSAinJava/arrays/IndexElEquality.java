package DSAinJava.arrays;

public class IndexElEquality {
    static int indexEqualsValueSearch(int[] arr) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<mid){
                low=mid+1;
            }
            else if(arr[mid]>mid){
                high=mid-1;
            }
            else{//arr[mid]=mid
                if(mid==0||arr[mid-1]<mid-1) return mid;
                else high=mid-1;//means arr[mid-1]=mid-1
            }
        }
        return -1;
    }
}
