package arrays;
import java.util.*;
public class fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                //two pointer
                int low=j+1;
                int high=n-1;
                while(low<high){
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[low]+(long)nums[high];

                    if(sum<target){
                        low++;
                    }
                    else if(sum>target){
                        high--;
                    }
                    else{
                        List<Integer>list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);

                        res.add(list);

                        low++;
                        high--;

                        while(low<high && nums[low]==nums[low-1]) low++;
                        while(low<high &&nums[high]==nums[high+1]) high--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        int[] nums={0,-1,2,-3,1};
        List<List<Integer>> res=fourSum(nums,0);

    }
}
