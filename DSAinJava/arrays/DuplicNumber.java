package arrays;
import java.util.*;
public class DuplicNumber {
    public static int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
    public int findDuplicate2(int[] arr) {
        int i=0;
        while(i<arr.length){
            if(arr[i]!=i+1){
                int correctIndex=arr[i]-1;
                if(arr[i]!=arr[correctIndex]){
                    swap(arr,i,correctIndex);
                }
                else{
                    return arr[i];
                }
            }
            else{
                i++;
            }
        }
        return -1;
    }
    //multiple
    public List<Integer> findDuplicates(int[] arr) {
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
                list.add(arr[i]);
            }
        }
        return list;
    }
    //duplicate and missing both
    public int[] findErrorNums(int[] arr) {
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
        int ans[]=new int[2];
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                ans[0]=arr[i];
                ans[1]=i+1;
            }
        }
        return ans;
    }
    static void swap(int[] arr,int i,int correctIndex){
        int temp=arr[i];
        arr[i]=arr[correctIndex];
        arr[correctIndex]=temp;
    }
    public static void main(String[] args){
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
