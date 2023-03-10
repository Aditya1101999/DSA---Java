package Graphs;
import java.util.*;
public class CycleDirected {
    public boolean isCycleDFS(int V,ArrayList<ArrayList<Integer>>adj){
        boolean[] visited=new boolean[V];
        boolean[] pathVisited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfsCheck(i,adj,visited,pathVisited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node]=true;
        pathVisited[node]=true;
        //traverse for adjacent nodes
        for(int el: adj.get(node)) {
            if (!visited[el]) {
                if (dfsCheck(el, adj, visited, pathVisited)) {//cycle found
                    return true;
                }
            } else if (pathVisited[el]) {//cycle found as node is visited on the same path again
                return true;
            }
        }
        pathVisited[node]=false;//backtrack for path visited
        return false;
    }
    public static boolean topoSortBFS(int V,ArrayList<ArrayList<Integer>>adj){//Kahn Algo
        int[] inDegree=new int[V];
        for(int i=0;i<V;i++){
            for(int node: adj.get(i)){
                inDegree[node]++;//increasing freq
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        int index=0;
        while(!q.isEmpty()){
            int node=q.remove();
            count++;
            for(int i :adj.get(node)){
                inDegree[i]--;//decreasing the freq of removed nodes
                if(inDegree[i]==0){
                    q.add(i);
                }
            }
        }
        if(count==V) return false;//topo sort completed->no cycle found
        return true;
    }

}
