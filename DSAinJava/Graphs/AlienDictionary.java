package DSAinJava.Graphs;
import java.util.*;
public class AlienDictionary {
    public static String findOrder(String [] dict, int N, int K){
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){//pair formation
            String str1=dict[i];
            String str2=dict[i+1];
            int limit=Math.min(str1.length(),str2.length());
            for(int j=0;j<limit;j++){
                if(str1.charAt(j)!=str2.charAt(j)){
                    adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    break;//one character comparison for each pair,
                    //in order to avoid contradiction
                }
            }
        }
        List<Integer>topo=topoSort(adj,K);
        StringBuilder ans= new StringBuilder();
        for(int el:topo){
            ans.append((char) (el + 'a'));
        }
        return ans.toString();
    }
    private static List<Integer> topoSort(List<List<Integer>>adj,int K){
        int[] inDegree=new int[K];
        for(int i=0;i<K;i++){
            for(int node:adj.get(i)){
                inDegree[node]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<K;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        List<Integer>topo=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.remove();
            topo.add(curr);
            for(int node:adj.get(curr)){
                inDegree[node]--;
                if(inDegree[node]==0){
                    q.add(node);
                }
            }
        }
        return topo;
    }
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};
        System.out.println(findOrder(dict,N,K));
    }
}
