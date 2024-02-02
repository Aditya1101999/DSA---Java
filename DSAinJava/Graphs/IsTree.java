package DSAinJava.Graphs;
import java.util.*;
public class IsTree {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges)
    {
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(ArrayList<Integer>edge: edges){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        boolean[] visited=new boolean[n];
        if (!dfs(0,-1,visited,graph)) return false;
        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    private boolean dfs(int node,int parent,boolean[] visited,List<List<Integer>>graph){
        visited[node]=true;
        for(int i : graph.get(node)){
            if(!visited[i]){
                if(!dfs(i,node,visited,graph)) return false;
            }
            else if(i!=parent){
                return false;
            }
        }
        return true;
    }
}
