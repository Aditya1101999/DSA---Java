package DSAinJava.Graphs;
import java.util.*;
public class BellManFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dis=new int[V];
        Arrays.fill(dis,(int)1e8);
        dis[S]=0;
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer>edge:edges){
                int u=edge.get(0);
                int v=edge.get(1);
                int wt=edge.get(2);
                if(dis[u]+wt<dis[v]){
                    dis[v]=dis[u]+wt;
                }
            }
        }
        //Nth iteration to check if weights are still reducing
        //If yes , negative cycle exists
        for(ArrayList<Integer>edge:edges){
            int u=edge.get(0);
            int v=edge.get(1);
            int wt=edge.get(2);
            if(dis[u]+wt<dis[v]){
                return new int[]{-1};
            }
        }
        return dis;
    }

}
