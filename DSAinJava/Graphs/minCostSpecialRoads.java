package DSAinJava.Graphs;
import java.util.*;
public class minCostSpecialRoads {
    class Pair{
        int cost;
        int index;
        Pair(int cost,int index){
            this.cost=cost;
            this.index=index;
        }
    }
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n=specialRoads.length;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        int[] dis=new int[n];
        for(int i=0;i<n;i++){//start->road
            dis[i]=Math.abs(start[0]-specialRoads[i][0])+Math.abs(start[1]-specialRoads[i][1])+specialRoads[i][4];
            pq.add(new Pair(dis[i],i));
        }
        int ans=Math.abs(start[0]-target[0])+Math.abs(start[1]-target[1]);
        while(!pq.isEmpty()){
            int currCost=pq.peek().cost;
            int index=pq.peek().index;
            pq.poll();

            if(currCost>dis[index]){
                continue;
            }

            ans=Math.min(ans,currCost+Math.abs(target[0]-specialRoads[index][2])+Math.abs(target[1]-specialRoads[index][3]));
            for(int nextRoad=0;nextRoad<n;nextRoad++){
                int cost=Math.abs(specialRoads[nextRoad][0]-specialRoads[index][2])+Math.abs(specialRoads[nextRoad][1]-specialRoads[index][3])+specialRoads[nextRoad][4];
                if(currCost+cost<dis[nextRoad]){
                    dis[nextRoad]=currCost+cost;
                    pq.add(new Pair(dis[nextRoad],nextRoad));
                }
            }
        }
        return ans;
    }
}
