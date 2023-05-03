package DSAinJava.arrays;
import java.util.*;
public class DiffArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getUniqueElements(nums1,nums2),getUniqueElements(nums2,nums1));
    }
    private List<Integer> getUniqueElements(int[] nums1,int[] nums2){
        Set<Integer>set=new HashSet<>();
        for(int num:nums2){
            set.add(num);
        }
        Set<Integer>ans=new HashSet<>();
        for(int num:nums1){
            if(!set.contains(num)){
                ans.add(num);
            }
        }
        return new ArrayList<>(ans);
    }
}
