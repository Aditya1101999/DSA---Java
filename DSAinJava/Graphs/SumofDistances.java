package Graphs;
import java.util.*;
public class SumofDistances {
    private static int[] res;
    private static  int[] count;
    private static List<HashSet<Integer>>tree;
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree=new ArrayList<HashSet<Integer>>();
        res=new int[n];
        count=new int[n];
        for(int i=0;i<n;i++){
            tree.add(new HashSet<Integer>());
        }
        for(int[] e:edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        postOrder(0,-1);
        preOrder(0,-1);
        return res;
    }
    public static  void postOrder(int root,int prev){
        for(int i:tree.get(root)){//all the children of given root
            if(i==prev) continue;
            postOrder(i,root);//postOrder on child
            count[root]+=count[i];
            res[root]+=res[i]+count[i];
        }
        count[root]++;//adding one node as the root itself
    }
    public static void preOrder(int root,int prev){
        for(int i:tree.get(root)){//all the children of given root
            if(i==prev) continue;
            //count[i] is the node count which are coming closer , so their distance will be reduced
            //similarly , n-count[i] are the nodes going farther , so distance will increase
            res[i]=res[root]-count[i]+(count.length-count[i]);
            preOrder(i,root);
        }
    }
    public static void main(String[] args){
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int[] res=sumOfDistancesInTree(n,edges);
        for(int i=0;i<res.length;i++) {
            System.out.print(res[i]+" ");
        }
    }
}
