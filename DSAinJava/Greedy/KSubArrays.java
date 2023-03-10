package Greedy;
import java.util.*;
public class KSubArrays {
    public static int splitArray(int[] nums,int m){
        int maxNo=0;//low
        int total=0;//high
        for(int el:nums){
            maxNo=Math.max(el,maxNo);
            total+=el;
        }
        int low=maxNo;
        int high=total;
        while(low<high){
            int mid=low+(high-low)/2;
            if(validDivisionPossible(mid,nums,m)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static boolean validDivisionPossible(int mid,int[] nums,int m){
        int totSubsets=1;
        int totRunningSum=0;
        for(int num:nums){
            totRunningSum+=num;
            if(totRunningSum>mid){
                totRunningSum=0;//reset
                totRunningSum+=num;
                totSubsets++;
                if(totSubsets>m){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] nums={1,1,2};
        int m=2;
        System.out.print(splitArray(nums,m));
    }
}
