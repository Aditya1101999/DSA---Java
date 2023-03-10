package DSAinJava.Graphs;
import java.util.*;
public class CycleUndirected {
    static class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean isCycleBFS(int V,ArrayList<ArrayList<Integer>>adj){
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){//disconnected components
            if(!visited[i]){
                return checkForCycleBFS(i,V,adj,visited);
            }
        }
        return false;
    }
    public boolean checkForCycleBFS(int src,int V,ArrayList<ArrayList<Integer>>adj,boolean[] visited){
        visited[src]=true;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            int node=q.remove().node;
            int parent=q.remove().parent;
            q.remove();
            for(int e:adj.get(node)){
                if(!visited[e]){
                    visited[e]=true;
                    q.add(new Pair(e,node));
                }
                //node already visited
                else if(e!=parent){//cycle exists
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycleDFS(int V,ArrayList<ArrayList<Integer>>adj){
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){//disconnected components
            if(!visited[i]){
                return checkForCycleDFS(i,-1,adj,visited);
            }
        }
        return false;
    }
    private boolean checkForCycleDFS(int node,int parent,ArrayList<ArrayList<Integer>>adj,boolean[] visited){
        visited[node]=true;
        for(int el:adj.get(node)){
            if(!visited[el]){
                return checkForCycleDFS(el,node,adj,visited);
            }
            else if(el!=parent){//visited and element is not parent
                return true;
            }
        }
        return false;
    }

}
