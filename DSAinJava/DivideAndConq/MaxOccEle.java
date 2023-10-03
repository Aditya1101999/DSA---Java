package DSAinJava.DivideAndConq;
import java.util.*;
public class MaxOccEle {
    public int majorityElement(int[] nums) {//>n/2 times
        int count=0;
        int el=0;
        for(int num:nums){
            if(count==0){
                el=num;
            }
            if(num==el){
                count++;
            }
            else{
                count--;
            }
        }
        return el;
    }
    public List<Integer> majorityElement2(int[] nums) {//>n/3 times
        int count1=0;
        int el1=-1;
        int count2=0;
        int el2=-1;
        for(int num:nums){
            if(num==el1) count1++;
            else if(num==el2) count2++;
            else if(count1==0 && num!=el2){
                el1=num;
                count1++;
            }
            else if(count2==0 && num!=el1){
                el2=num;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        int n=nums.length;
        count1=0;
        count2=0;
        ArrayList<Integer>ans=new ArrayList<>();
        for(int num:nums){
            if(num==el1) count1++;
            else if(num==el2) count2++;
        }
        if(count1>n/3) ans.add(el1);
        if(count2>n/3) ans.add(el2);
        return ans;
    }
    public static int inRange(int[] nums,int num,int si,int ei){
        int count=0;
        for(int i=0;i<=ei;i++){
            if(nums[i]==num){
                count++;
            }
        }
        return count;
    }
    public static int majElementFinder(int[] nums,int si,int ei){
        //base case
        if(si==ei){//1 element
            return nums[si];
        }
        int mid=si+(ei-si)/2;
        int left=majElementFinder(nums,si,mid);
        int right=majElementFinder(nums,mid+1,ei);
        //if two halves agree on a majority element
        if(left==right){
            return left;
        }
        //else,count each element
        int leftCount=inRange(nums,left,si,mid);
        int rightCount=inRange(nums,right,mid+1,ei);
        /*if(leftCount>rightCount){
            return left;
        }
        else{
            return right;
        }*/
        return leftCount>rightCount?left:right;
    }
    public static void main(String args[]){
        int nums[]={2,2,1,1,1,2,2};
        System.out.println(majElementFinder(nums,0, nums.length-1));
    }
}
