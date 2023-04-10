package DSAinJava.Graphs;
import java.util.*;
public class EventualSafeStates {
    public List<Integer> eventualSafeNodesDFS(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        boolean[] visited=new boolean[n];
        boolean[] pathVisited=new boolean[n];
        boolean[] check=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]) dfs(i,adj,visited,pathVisited,check);
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]) ans.add(i);
        }
        return ans;
    }
    private boolean dfs(int node,ArrayList<ArrayList<Integer>>adj,boolean[] visited,boolean[] pathVisited,
                        boolean[] check){//cycle detection
        visited[node]=true;
        pathVisited[node]=true;

        for(int i : adj.get(node)){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathVisited,check)) return true;
            }
            else if(pathVisited[i]){//&& visited[i]
                return true;
            }
        }
        check[node]=true;
        pathVisited[node]=false;
        return false;
    }
    public List<Integer> eventualSafeNodesBFS(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {//reversed graph
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
            }
        }
        int[] inDegree=new int[n];
        for(int i=0;i<n;i++){
            for(int node: adj.get(i)){
                inDegree[node]++;//increasing freq
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0) q.add(i);
        }
        List<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            ans.add(node);
            for(int i:adj.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0) q.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
