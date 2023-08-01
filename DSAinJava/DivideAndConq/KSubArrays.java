package DSAinJava.DivideAndConq;
public class KSubArrays {//same solution for painter's partition
    public static int splitArray(int[] nums,int m){
        if(m> nums.length) return -1;
        int maxNo=0;//low
        int total=0;//high
        for(int el:nums){
            maxNo=Math.max(el,maxNo);
            total+=el;
        }
        int low=maxNo;
        int high=total;
        while(low<=high){
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
        int currSum=0;
        for(int num:nums){
            if(currSum+num>mid){
                totSubsets++;
                currSum=num;
                if(totSubsets>m){
                    return false;
                }
            }
            else{
                currSum+=num;
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
