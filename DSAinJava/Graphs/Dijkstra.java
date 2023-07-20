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
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        //1-based indexing
        int[] dis=new int[n+1];
        int[] parent=new int[n+1];
        for(int i=1;i<n+1;i++){
            dis[i]=(int)(1e9);
            parent[i]=i;
        }
        dis[1]=0;
        pq.add(new Pair(1,0));//Source
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int u=pq.peek().distance;
            pq.remove();
            for(Pair i : adj.get(node)){
                int wt=i.distance;
                int v=i.node;
                if(u+wt<dis[v]){
                    dis[v]=u+wt;
                    pq.add(new Pair(v,dis[v]));
                    parent[v]=node;
                }
            }
        }
        List<Integer>path=new ArrayList<>();
        if(dis[n]==1e9){
            path.add(-1);
            return path;
        }
        int node=n;
        while(parent[node]!=node){//until source is reached
            path.add(node);
            node=parent[node];
        }
        path.add(1);//source
        Collections.reverse(path);
        return path;
    }
}
