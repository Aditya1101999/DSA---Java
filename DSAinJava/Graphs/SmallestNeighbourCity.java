package DSAinJava.Graphs;
import java.util.*;
public class SmallestNeighbourCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis=new int[n][n];
        for(int[] arr:dis){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int m=edges.length;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            dis[u][v]=dis[v][u]=wt;//undirected graph
        }
        for(int i=0;i<n;i++){
            dis[i][i]=0;//src
        }
        //Floyd
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){//try to go via every possible node
                    if (dis[i][k] == Integer.MAX_VALUE ||
                            dis[k][j] == Integer.MAX_VALUE)//no direct node
                        continue;
                    dis[i][j]=Math.min(dis[i][j],
                            dis[i][k]+dis[k][j]);
                }
            }
        }
        int maxCount=n;
        int maxCity=-1;
        for(int city=0;city<n;city++){
            int count=0;
            for(int adjCity=0;adjCity<n;adjCity++){
                if(dis[city][adjCity]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=maxCount){
                maxCount=count;
                maxCity=city;
            }
        }
        return maxCity;
    }
    class Pair{
        int node;
        int distance;
        public Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public int findTheCityDijkstra(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        int maxCity=-1;
        int maxCount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){//for each city
            int[] dis=new int[n];
            Arrays.fill(dis,Integer.MAX_VALUE);
            dis[i]=0;
            pq.add(new Pair(i,0));
            while(!pq.isEmpty()){
                int node=pq.peek().node;
                int u=pq.peek().distance;
                pq.poll();
                for(Pair it:graph.get(node)){
                    int v=it.node;
                    int wt=it.distance;
                    if(u+wt<dis[v]){
                        dis[v]=u+wt;
                        pq.add(new Pair(v,dis[v]));
                    }
                }
            }
            int count=0;
            for(int j=0;j<n;j++){
                if(dis[j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=maxCount){
                maxCount=count;
                maxCity=i;
            }
        }
        return maxCity;
    }
}
