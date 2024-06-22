package DSAinJava.arrays;
import java.util.*;
public class IntegerAdded {
    public int addedInteger(int[] nums1, int[] nums2) {
        int sum=0;
        int n=nums1.length;
        for(int i=0;i<n;i++){
            sum+=nums2[i]-nums1[i];
        }
        return sum/n;

    }
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Map<Integer,Integer>map=new HashMap<>();
        for(int el1 : nums1){
            for(int el2 : nums2){
                int diff=el2-el1;
                map.put(diff,map.getOrDefault(diff,0)+1);
            }
        }
        int minDiff=1000;
        for(int diff : map.keySet()){
            List<Integer>curr=new ArrayList<>();
            for(int el : nums1){
                curr.add(el+diff);
            }
            if(isValid(curr,nums2)) minDiff=Math.min(diff,minDiff);
        }
        return minDiff;
    }
    private boolean isValid(List<Integer>curr,int[] nums){
        int buffer=2;
        int i=0;
        int j=0;
        while(i<curr.size() && j<nums.length){
            if(curr.get(i)==nums[j]){
                i++;
                j++;
            }
            else{
                i++;
                buffer--;
                if(buffer<0) return false;
            }
        }
        return j==nums.length;
    }
}
