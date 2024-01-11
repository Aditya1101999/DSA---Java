package DSAinJava.arrays;
import java.util.*;
public class SubarrayDivK {
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();//remainder,freq
        map.put(0,1);//default case
        int count=0;
        int runningSum=0;
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            int remainder=runningSum%k;
            if(remainder<0){
                remainder+=k;
            }
            if(map.containsKey(remainder)){
                count+=map.get(remainder);
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return count;
    }
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int runningSum=0;
        int remainder=0;
        int ans=0;
        for(int i=0;i<n;i++){
            runningSum+=a[i];
            remainder=runningSum%k;
            if(remainder<0){
                remainder+=k;
            }
            if(map.containsKey(remainder)){
                ans=Math.max(ans,i-map.get(remainder));
            }
            else{
                map.put(remainder,i);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={4,5,0,-2,-3,1};
        int k= 5;
        System.out.println(subarraysDivByK(nums,k));
    }
}
