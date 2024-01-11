package DSAinJava.Hashing;
import java.util.*;
public class maxSetSize {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n=nums1.length;
        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();
        Set<Integer>common=new HashSet<>();
        for(int el : nums1){
            set1.add(el);
        }
        for(int el : nums2){
            set2.add(el);
            if(set1.contains(el)) common.add(el);
        }
        int maxElementsSet1=Math.min(n/2,set1.size()-common.size());
        int maxElementsSet2=Math.min(n/2,set2.size()-common.size());
        return Math.min(n,(maxElementsSet1+maxElementsSet2+common.size()));
    }
}
