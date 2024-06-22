package DSAinJava.Hashing;
import java.util.*;
public class IntersectionArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>anss=new HashSet<>();
        Set<Integer>visited=new HashSet<>();
        for(int el : nums1){
            visited.add(el);
        }
        for(int el : nums2){
            if(visited.contains(el)){
                anss.add(el);
            }
        }
        int[] ans=new int[anss.size()];
        int index=0;
        for(int el : anss){
            ans[index++]=el;
        }
        return ans;
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int el : nums1){
            map.put(el,1);
        }
        List<Integer>ans=new ArrayList<>();
        for(int el : nums2){
            if(map.containsKey(el) && map.get(el)==1){
                ans.add(el);
                map.put(el,0);
            }
        }
        int[] arr=new int[ans.size()];
        int index=0;
        for(int el : ans){
            arr[index++]=el;
        }
        return arr;
    }
}
