package Graphs;
import java.util.*;
public class AllPaths {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        path.add(0);
        dfs(0,graph,res,path);
        return res;
    }
    public void dfs(int node,int[][] graph,List<List<Integer>>res,List<Integer>path){
        if(node==graph.length-1){//one node
            res.add(new ArrayList<>(path));
            return;
        }
        for(int nextnode:graph[node]){
            path.add(nextnode);
            dfs(nextnode,graph,res,path);
            path.remove(path.size()-1);
        }
    }
}
