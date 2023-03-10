package Graphs;
import java.util.*;
public class TopologicalSort {
    public static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited=new boolean[V];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,st,adj);
            }
        }
        int[] ans=new int[V];
        int i=0;
        while(!st.isEmpty()){
            ans[i++]=st.pop();
        }
        return ans;
    }
    private static void dfs(int i,boolean[] visited,Stack<Integer>st,ArrayList<ArrayList<Integer>>adj){
        visited[i]=true;
        for(int node:adj.get(i)){
            if(!visited[node]){
                dfs(node,visited,st,adj);
            }
        }
        st.push(i);
    }
    public static int[] topoSortBFS(int V,ArrayList<ArrayList<Integer>>adj){//Kahn Algo
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
        int[] ans=new int[V];
        int index=0;
        while(!q.isEmpty()){
            int node=q.remove();
            ans[index++]=node;
            for(int i :adj.get(node)){
                inDegree[i]--;//decreasing the freq of removed nodes
                if(inDegree[i]==0){
                    q.add(i);
                }
            }
        }
        return ans;
    }
}
