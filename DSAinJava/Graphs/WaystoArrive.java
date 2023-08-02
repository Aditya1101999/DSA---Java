package DSAinJava.Graphs;
import java.util.*;
public class WaystoArrive {
    class Pair{
        int node;
        long distance;
        public Pair(int node,long distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road:roads){
            adj.get(road[0]).add(new Pair(road[1],road[2]));
            adj.get(road[1]).add(new Pair(road[0],road[2]));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Long.compare(a.distance,b.distance));
        long[] ways=new long[n];
        long[] dis=new long[n];
        int mod = (int)1e9+7;
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            long u=pq.peek().distance;
            pq.poll();
            for(Pair it : adj.get(node)){
                long wt=it.distance;
                int v=it.node;
                if(u+wt<dis[v]){
                    dis[v]=u+wt;
                    pq.add(new Pair(v,dis[v]));
                    ways[v]=ways[node];
                }
                else if(u+wt==dis[v]){
                    ways[v]=(ways[v]+ways[node])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}
