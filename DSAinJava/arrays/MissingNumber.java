package DSAinJava.arrays;
import java.util.*;
public class MissingNumber {
    static int missingNumber(int[] arr){
        int i=0;
        while(i<arr.length){
            if(arr[i]< arr.length&&arr[i]!=i){
                swap(arr,i,arr[i]);
            }
            else{
                i++;
            }
        }
        for(i=0;i< arr.length;i++){
            if(arr[i]!=i){
                return i;
            }
        }
        return arr.length;
    }
    static void swap(int[] arr,int i,int correctIndex){
        int temp=arr[i];
        arr[i]=arr[correctIndex];
        arr[correctIndex]=temp;
    }
    //multiple missing no.s
    public List<Integer> findDisappearedNumbers(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correctIndex=arr[i]-1;
            if(arr[i]!=arr[correctIndex]){
                swap(arr,i,correctIndex);
            }
            else{
                i++;
            }
        }
        List<Integer>list=new ArrayList<>();
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                list.add(i+1);
            }
        }
        return list;
    }
    public int firstMissingPositive(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correctIndex=arr[i]-1;
            if(arr[i]>0&&arr[i]<=arr.length&&arr[i]!=arr[correctIndex]){
                swap(arr,i,correctIndex);
            }
            else{
                i++;
            }
        }
        for(i=0;i< arr.length;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return arr.length+1;
    }
    public int firstMissingPositiveSorted(int[] arr) {
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==mid){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }


    public static void main(String[] args){
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
}
