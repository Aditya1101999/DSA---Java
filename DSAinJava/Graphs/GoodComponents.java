package DSAinJava.Graphs;
import java.util.*;
public class GoodComponents {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[v+1];
        int count=0;
        for(int i=1;i<=v;i++){
            if(!visited[i]){
                if(isGoodComponent(graph,visited,i)) count++;
            }
        }
        return count;
    }
    private static boolean isGoodComponent(List<List<Integer>>graph,boolean[] visited,int currNode){
        int[] nodeEdges=new int[2];
        isGoodComponentHelper(graph,visited,currNode,nodeEdges);
        /* a good component having n nodes will have n*(n-1)/2 edges
        but since every edge is being counted twice by the two nodes sharing it
        edges/2=n*(n-1)/2
        */
        return (nodeEdges[1]==nodeEdges[0]*(nodeEdges[0]-1));
    }
    private static void isGoodComponentHelper(List<List<Integer>>graph,boolean[] visited,int currNode,int[] nodeEdges){
        visited[currNode]=true;
        nodeEdges[0]++;
        nodeEdges[1]+=graph.get(currNode).size();//number of nodes connected to it
        for(int el : graph.get(currNode)){
            if(!visited[el]){
                isGoodComponentHelper(graph,visited,el,nodeEdges);
            }
        }
    }
}
