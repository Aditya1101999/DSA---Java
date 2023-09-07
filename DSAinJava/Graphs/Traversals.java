package Graphs;
import java.util.*;
public class Traversals {

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>>graph,int V){
        ArrayList<Integer>bfs=new ArrayList<>();
        boolean[] vis=new boolean[V];
        Queue<Integer>q=new LinkedList<>();
        q.add(0);//source
        vis[0]=true;

        while(!q.isEmpty()) {
            int curr = q.remove();
            bfs.add(curr);

            for (int el : graph.get(curr)) {
                if (!vis[el]) {
                    vis[el] = true;
                    q.add(el);
                }
            }
        }
        return bfs;
    }
    public static ArrayList<Integer>dfs(ArrayList<ArrayList<Integer>>graph,int V){
        ArrayList<Integer>dfs=new ArrayList<>();
        boolean[] vis=new boolean[V];
        vis[0]=true;
        dfsHelper(0,vis,graph,dfs);
        return dfs;
    }
    public static void dfsHelper(int node,boolean[] vis,ArrayList<ArrayList<Integer>>graph,ArrayList<Integer>dfs){
        vis[node]=true;
        dfs.add(node);

        for(int el:graph.get(node)){
            if(!vis[el]){
                dfsHelper(el,vis,graph,dfs);
            }
        }
    }
}
