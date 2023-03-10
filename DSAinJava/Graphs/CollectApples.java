package Graphs;
import java.util.*;
public class CollectApples {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>>adjacencyList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
        boolean[] visited=new boolean[n];
        for(int[] e:edges){
            adjacencyList.get(e[0]).add(e[1]);
            adjacencyList.get(e[1]).add(e[0]);
        }
        return dfs(adjacencyList,visited,hasApple,0);
    }
    private static int dfs(List<List<Integer>>adjacencyList,boolean[] visited,List<Boolean> hasApple,int index){
        int time=0;
        visited[index]=true;
        for(int i:adjacencyList.get(index)){
            if(!visited[i]){
                time+=dfs(adjacencyList,visited,hasApple,i);
            }
        }
        if(index==0){
            return time;
        }
        if(hasApple.get(index)||time>0){//node has or had apples
            time+=2;//1 unit each for going and returning
        }
        return time;
    }
    public static void main(String[] args){
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple =new ArrayList<>();
        //{false,false,true,false,true,true,false};
        hasApple.add(false);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(true);
        hasApple.add(false);
        System.out.println(minTime(n,edges,hasApple));



    }
}
