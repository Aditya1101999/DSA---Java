package DSAinJava.arrays;
import java.util.*;
public class threesum{
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){//if last two elements can act as triplets with i
            if(i==0||nums[i]!=nums[i-1]){//triplets should be unique
                //two-pointer
                int low=i+1;
                int high=nums.length-1;
                int sum=-nums[i];//b+c=-a
                while(low<high){
                    if(nums[low]+nums[high]==sum){
                        res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        //avoid duplicate elements
                        while(low<high&&nums[low]==nums[low+1]) low++;
                        while(low<high&&nums[high]==nums[high-1]) high--;

                        low++;high--;
                    }
                    else if(nums[low]+nums[high]<sum){
                        low++;
                    }
                    else{
                        high--;
                    }
                }

            }
        }
        return res;

    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum=0;
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){//if last two elements can act as triplets with i
            //two-pointer
            int low=i+1;
            int high=nums.length-1;
            while(low<high){
                int sum=nums[i]+nums[low]+nums[high];
                int currDiff=Math.abs(target-sum);
                if(sum==target){
                    return sum;
                }
                else if(sum<target){
                    low++;
                }
                else{
                    high--;
                }
                if(currDiff<minDiff){
                    minDiff=currDiff;
                    closestSum=sum;
                }
            }

        }
        return closestSum;
    }
    long countTriplet(int N, int A[],int X)
    {
        long ans=0,p=0,q=0;
        for(int k=X;k<N;k++)
        {
            if(A[k]%2==1)
                q++;
        }

        for(int j=0;j<N;j++)
        {

            if(j-X>=0&&A[j-X]%2==1)
                p++;

            if(A[j]%2==1)
                ans+=p*q;

            if(j+X<N&&A[j+X]%2==1)
                q--;
        }
        return ans;
    }
    public static void main(String args[]){
        int[] nums={0,-1,2,-3,1};
        List<List<Integer>> res=threeSum(nums);

    }
}
