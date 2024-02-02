package DSAinJava.Heaps;
import java.util.*;
public class ConstrainedSubseqSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{nums[0],0});
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            while(!pq.isEmpty() && i-pq.peek()[1]>k){
                pq.poll();
            }
            int curr=Math.max(pq.peek()[0]+nums[i],nums[i]);
            max=Math.max(max,curr);
            pq.add(new int[]{curr,i});
        }
        return max;
    }
    public int constrainedSubsetSumDeque(int[] nums, int k) {
        Deque<int[]>q=new ArrayDeque<>();
        q.add(new int[]{nums[0],0});
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            while(!q.isEmpty() && i-q.peek()[1]>k){
                q.poll();
            }
            int curr=Math.max(q.peek()[0]+nums[i],nums[i]);
            max=Math.max(max,curr);
            while(!q.isEmpty() && q.peekLast()[0]<=curr){
                q.pollLast();
            }
            q.add(new int[]{curr,i});
        }
        return max;
    }
}
