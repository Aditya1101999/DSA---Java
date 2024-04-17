package DSAinJava.Graphs;
import java.util.*;
public class DisappearingNodes {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int[] result=new int[n];
        boolean[] visited=new boolean[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});//node , time
        result[0]=0;
        while(!pq.isEmpty()){
            int curr=pq.peek()[0];
            int u=pq.peek()[1];
            pq.poll();
            if(visited[curr]) continue;
            visited[curr]=true;
            for(int[] edge : graph.get(curr)){
                int node=edge[0];
                int time=edge[1];
                if(u+time<result[node] && u+time<disappear[node]){
                    result[node]=u+time;
                    pq.add(new int[]{node,result[node]});
                }
            }
        }
        for(int i=0;i<n;i++){
            if(result[i]==Integer.MAX_VALUE) result[i]=-1;
        }
        return result;
    }
}
