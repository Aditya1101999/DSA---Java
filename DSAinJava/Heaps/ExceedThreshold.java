package DSAinJava.Heaps;
import java.util.PriorityQueue;
public class ExceedThreshold {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long>pq=new PriorityQueue<>();
        for(int el : nums){
            pq.add((long)el);
        }
        int op=0;
        while(pq.size()>=2){
            if(pq.peek()>=k) return op;
            long x=pq.poll();
            long y=pq.poll();
            pq.add(Math.min(x, y) * 2 + Math.max(x, y));
            op++;
        }
        return op;
    }
}
