package DSAinJava.DivideAndConq;

public class KthMissing {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int missingNo=arr[mid]-(mid+1);//no-original no.
            if(missingNo<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low+k;
        /*
        we know at a point , high will cross low and high+1==low(when binary search stops)
        so then , missing no.=arr[high]+k-missing no.s at that point
                             =arr[high]+k-(arr[high]-(high+1))
                             =k+low */
    }
}
