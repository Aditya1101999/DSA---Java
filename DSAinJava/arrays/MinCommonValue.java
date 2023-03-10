package arrays;
import java.util.*;
public class MinCommonValue {
    public static int getCommon(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], 1);
        }
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(nums2[i])) {
                return nums2[i];
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums1={1,2,3};
        int[] nums2={2,4};
        System.out.println(getCommon(nums1,nums2));
    }

}
