package DSAinJava.Heaps;
import java.util.*;
public class maxSubseq {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.comparingInt(i->nums[i]));//minheap storing indices
        for(int i=0;i<nums.length;i++){
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
        return pq.stream().sorted().mapToInt(i->nums[i]).toArray();
    }
}
