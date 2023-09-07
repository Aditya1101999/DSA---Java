package DSAinJava.DivideAndConq;
import java.util.*;
public class MergeSort {
    public static void mergeSort(int arr[],int si,int ei){
        //base case
        if(si>=ei){//single element
            return;
        }
        int mid=si+(ei-si)/2;//to avoid overflow
        mergeSort(arr, si, mid);//left
        mergeSort(arr, mid+1, ei);//right
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        //iterators
        int i=si;//for left part
        int j=mid+1;//for right part
        int k=0;//for mp array

        while(i<=mid && j<=ei){
            //left array
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }
            //right array
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        //for leftover elements in left part
        while(i<=mid){
            temp[k++]=arr[i++];//combined i++ and k++
        }
        //for leftover elements in right part
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        //copy temp array to original array
        for(k=0,i=si;k< temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1;
        int right=0;
        while(left>=0 && right<n){
            if(nums1[left]>nums2[right]){
                swap(nums1[left],nums2[right]);
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
    //to store values in two different arrays
    public void merge(int[] nums1, int m, int[] nums2, int n) {//shell sort
        int gap = (int) Math.ceil((m + n) / 2);
        while (gap > 0) {
            int i = 0;
            int j = gap;
            while (j < (m + n)) {
                if (j < m && nums1[i] > nums1[j]) {//both elements in 1st array
                    swap(nums1[i], nums1[j]);
                } else if (j >= m && i <m && nums1[i] > nums2[j - m]) {//1 element in 1st and 1 in 2nd array
                    swap(nums1[i], nums2[j - m]);
                } else if (i >= m && nums2[i - m] > nums2[j - m]) {//both elements in 2nd array
                    swap(nums2[i - m], nums2[j - m]);//if i is on right , j will always be on right
                }
                i++;
                j++;
            }
            if (gap == 1) gap = 0;
            else gap = (int) Math.ceil(gap / 2);
        }
    }
        private void swap ( int a, int b){
            int temp = a;
            a = b;
            b = temp;
        }
        //to store values in a single array
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int i=m+n-1;//last index
        while(p2>=0){
            if(p1>=0&&nums1[p1]>nums2[p2]){
                nums1[i--]=nums1[p1--];
            }
            else{
                nums1[i--]=nums2[p2--];
            }
        }
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[]={6,3,9,5,2,8};
        mergeSort(arr,0, arr.length-1);
        printarr(arr);
    }
}
