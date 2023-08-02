package DSAinJava.Graphs;
import java.util.*;
public class CheapestFlights {
    class Pair{
        int node;
        int dis;
        public Pair(int node,int dis){
            this.node=node;
            this.dis=dis;
        }
    }
    class Tuple{
        int stops;
        int dis;
        int node;
        public Tuple(int stops,int dis,int node){
            this.stops=stops;
            this.dis=dis;
            this.node=node;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            graph.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<Tuple>q=new LinkedList<>();
        int[] dis=new int[n];
        for(int i=0;i<n;i++){
            dis[i]=(int)1e9;
        }
        dis[src]=0;
        q.add(new Tuple(0,0,src));
        while(!q.isEmpty()){
            int stops=q.peek().stops;
            int u=q.peek().dis;
            int node=q.peek().node;
            q.remove();
            for(Pair it : graph.get(node)){
                int adjNode=it.node;
                int wt=it.dis;
                if(u+wt<dis[adjNode] && stops<=k){
                    dis[adjNode]=u+wt;
                    q.add(new Tuple(stops+1,dis[adjNode],adjNode));
                }
            }
        }
        return dis[dst]==1e9 ? -1 : dis[dst];
    }
}
