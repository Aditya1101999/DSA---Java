package Graphs;
import java.util.*;
public class PossibleBipartition {
    public boolean isBipartiteBFS(int[][] graph) {
        int[] color=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(color[i]==0){
                if(!bfs(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int start,int[][] graph,
                        int[] color){
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        color[start]=1;//colors are 1 or -1;
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int neighbour:graph[curr]){
                if(color[neighbour]==color[curr]){
                    return false;
                }
                if(color[neighbour]==0){
                    color[neighbour]=-color[curr];//opposite color
                    q.add(neighbour);
                }
            }
        }
        return true;
    }
    public boolean isBipartiteDFS(int[][] graph) {
        int[] color=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(color[i]==0){
                if(!dfs(i,1,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int start,int col,int[][] graph,
                        int[] color){
        color[start]=col;//colors are 1 or -1;
            for(int neighbour:graph[start]){
                if(color[neighbour]==col){
                    return false;
                }
                if(color[neighbour]==0){
                    if(!dfs(neighbour,-col,graph,color)){
                        return false;
                    }
                }
            }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color=new int[n+1];
        List<Integer>[]graph=new List[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] v:dislikes){
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }
        for(int i=1;i<=n;i++){
            if(color[i]==0){//no color
                Queue<Integer>q=new LinkedList<>();
                q.add(i);
                color[i]=1;//colors are 1 and -1
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int neighbour:graph[curr]){
                        if(color[neighbour]==color[curr]){
                            return false;
                        }
                        if(color[neighbour]==0){
                            color[neighbour]=-color[curr];
                            q.add(neighbour);
                        }
                    }
                }
            }
        }
        return true;
    }
}
