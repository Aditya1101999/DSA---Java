package DSAinJava.Graphs;
import java.util.*;
public class Prim {
    static class Pair{
        int node;
        int distance;
        public Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    static int spanningTree(int V, int E, int edges[][]){
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        boolean[] visited=new boolean[V];
        //if we require to print the MST , then store parent as well
        //initial parent will be -1
        pq.add(new Pair(0,0));
        int sum=0;
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int u=pq.peek().distance;
            pq.poll();
            if(!visited[node]){
                visited[node]=true;
                sum+=u;
                //we would have also stored the parent and node here if we required to
                //print the MST in a list
                for(Pair it:adj.get(node)){
                    int dis=it.distance;
                    int v=it.node;
                    if(!visited[v]){
                        pq.add(new Pair(v,dis));
                    }
                }
            }
        }
        return sum;
    }
}
