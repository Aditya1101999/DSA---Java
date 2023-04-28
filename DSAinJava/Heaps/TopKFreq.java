package DSAinJava.Heaps;
import java.util.*;
public class TopKFreq {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int el:nums){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));//minHeap
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            pq.add(new int[]{entry.getKey(),entry.getValue()});
            if(pq.size()>k){//not required if max-heap used
                pq.remove();
            }
        }
        int[] ans=new int[k];
        while(k>0){
            ans[k-1]=pq.remove()[0];
            k--;
        }
        return ans;
    }
}
