package DSAinJava.Heaps;
import java.util.*;
public class Skyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>>res=new ArrayList<>();
        List<int[]>heights=new ArrayList<>();

        for(int[] building:buildings){
            heights.add(new int[]{building[0],-building[2]});
            heights.add(new int[]{building[1],building[2]});
        }
        Collections.sort(heights,(a,b)->(a[0]-b[0]==0 ? a[1]-b[1] : a[0]-b[0]));
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->(b-a));//heights
        int prevMax=0;
        pq.add(0);

        for(int[] height:heights){
            if(height[1]<0){//starting point
                pq.add(-height[1]);
            }
            else{
                pq.remove(height[1]);
            }
            int currMax=pq.peek();
            if(currMax!=prevMax){
                List<Integer>curr=new ArrayList<>();
                curr.add(height[0]);//coordinate
                curr.add(currMax);//new height
                res.add(curr);
                prevMax=currMax;
            }
        }
        return res;
    }
}
