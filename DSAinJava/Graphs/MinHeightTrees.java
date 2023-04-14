package DSAinJava.Graphs;
import java.util.*;
public class MinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer>ans = new ArrayList<>();
            for (int i = 0; i < n; i++)
                ans.add(i);
            return ans;
        }
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] degree=new int[n];
        for(int i=0;i<n;i++){
            for(int node : adj.get(i)){
                degree[node]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1) q.add(i);//leaf nodes
        }
        int count=n;
        while(count>2){
            int size=q.size();
            count-=size;//leaf nodes found in the iteration
            while(size-->0){
                int leaf=q.remove();
                for(int node : adj.get(leaf)){
                    degree[node]--;
                    if(degree[node]==1){
                        q.add(node);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}
