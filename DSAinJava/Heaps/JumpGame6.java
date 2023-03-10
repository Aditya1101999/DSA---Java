package Heaps;
import java.util.PriorityQueue;

public class JumpGame6 {
    public int maxResult(int[] nums, int k) {
        if(nums.length==0) return 0;
        //<Scores,Index>
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[0]-a[0]);
        int maxScore=nums[0];
        pq.add(new int[]{nums[0],0});
        for(int i=1;i<nums.length;i++){
            while(!(i-pq.peek()[1]<=k)){//within ranges
                pq.remove();
            }
            int[] curr=pq.peek();
            maxScore=curr[0]+nums[i];
            pq.add(new int[]{maxScore,i});
        }
        return maxScore;
    }
}
