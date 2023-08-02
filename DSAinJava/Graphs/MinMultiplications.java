package DSAinJava.Graphs;
import java.util.*;
public class MinMultiplications {
    class Pair{
        int node;
        int steps;
        public Pair(int node,int steps){
            this.node=node;
            this.steps=steps;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair>q=new LinkedList<>();
        int mod=100000;
        int[] dis=new int[mod];
        for(int i=0;i<dis.length;i++){
            dis[i]=(int)1e9;
        }
        dis[start]=0;
        q.add(new Pair(start,0));
        while(!q.isEmpty()){
            int node=q.peek().node;
            int steps=q.peek().steps;
            q.remove();
            if(node==end) return steps;
            for(int i=0;i<arr.length;i++){
                int adjNode=(node*arr[i])%mod;
                if(steps+1<dis[adjNode]){
                    dis[adjNode]=steps+1;
                    q.add(new Pair(adjNode,dis[adjNode]));
                }
            }
        }
        return -1;
    }
}
