package DSAinJava.Graphs;
import java.util.*;
public class Dijkstra {
    static class Pair{
        int node;
        int distance;
        public Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        //min-heap
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        int[] dis=new int[V];
        for(int i=0;i<V;i++){
            dis[i]=(int)(1e9);
        }
        dis[S]=0;
        pq.add(new Pair(S,0));
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int u = pq.peek().distance;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).get(0);
                int wt = adj.get(node).get(i).get(1);

                if(u+wt<dis[v]){
                    dis[v]=u+wt;
                    pq.add(new Pair(v,dis[v]));
                }
            }
        }
        return dis;
    }
}
