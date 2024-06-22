package DSAinJava.Graphs;
import java.util.*;
public class DivisibilityTree {
    static int ans;
    public int minimumEdgeRemove(int n, int[][] edges) {
        ans=0;
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n+1];
        dfs(graph,visited,1);
        return ans;
    }
    private int dfs(List<List<Integer>>graph,boolean[] visited,int node){
        visited[node]=true;
        int nodeCount=1;
        for(int el : graph.get(node)){
            if(!visited[el]){
                int count=dfs(graph,visited,el);
                if(count%2==0) ans++;
                nodeCount+=count;
            }
        }
        return nodeCount;
    }
}
