package DSAinJava.DivideAndConq;

public class LowUpBound {
    //this is also the solution for insert position and ceil
    private int lowerBound(int[] arr,int x){//lowest index i such that arr[i]>=x
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=high-(low+high)/2;
            if(arr[mid]>=x){//could be an answer
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private int upperBound(int[] arr,int x){//lowest index i such that arr[i]>x
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=high-(low+high)/2;
            if(arr[mid]>=x){//could be an answer
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private int floor(int[] arr,int x){//largest no. such that arr[i]<=x
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=high-(low+high)/2;
            if(arr[mid]<=x){//could be an answer
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
