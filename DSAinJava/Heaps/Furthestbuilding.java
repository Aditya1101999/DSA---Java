package DSAinJava.Heaps;
import java.util.PriorityQueue;
public class Furthestbuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<n-1;i++){
            if(heights[i+1]>heights[i]){
                int gap=heights[i+1] - heights[i];
                pq.add(gap);
                if(pq.size()>ladders){//bricks
                    bricks-=pq.poll();
                    if(bricks<0){
                        return i;
                    }
                }
            }
        }
        return n-1;//last index
    }
}
