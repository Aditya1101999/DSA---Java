package DSAinJava.Graphs;
import java.util.*;
public class NodesToReachAll {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)]++; // Increment the inDegree count for the destination node
        }
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){//return the nodes with no inDegree
                result.add(i);
            }
        }
        return result;
    }
}
