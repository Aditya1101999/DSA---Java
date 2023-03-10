package Hashing;
import java.util.*;
public class LongComSeq {
    public static int longestConsecutive(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max=0;
        for(int num:nums){
            if(!set.contains(num-1)){//smallest element of sequence
                int curr=num;
                int count=1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                max=Math.max(max,count);
            }
        }
        return max;
    }
    public static void main(String args[]) {
        int arr[] = {100, 200, 1, 2, 3, 4};
        int lon = longestConsecutive(arr);
        System.out.println(lon);
    }
}
