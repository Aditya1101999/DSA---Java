package DSAinJava.Graphs;
import java.util.*;
public class AccountsMerge {
    class DSU{
        List<Integer>parent;
        List<Integer>rank;
        List<Integer>size;
        public DSU(int n){
            parent=new ArrayList<>();
            rank=new ArrayList<>();
            size=new ArrayList<>();
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
                rank.add(0);
            }
        }
        public int findUpar(int node){
            if(node==parent.get(node)){
                return node;
            }
            int Upar=findUpar(parent.get(node));
            parent.set(node,Upar);
            return Upar;
        }
        public void UnionByRank(int nodeA,int nodeB){
            int parentA=findUpar(nodeA);
            int parentB=findUpar(nodeB);
            if(parentA==parentB) return;
            if(rank.get(parentA)>rank.get(parentB)){
                parent.set(parentB,parentA);
            }
            else if(rank.get(parentB)>rank.get(parentA)){
                parent.set(parentA,parentB);
            }
            else{
                parent.set(parentA,parentB);
                rank.set(parentB,rank.get(parentA)+1);
            }
        }
        public void UnionBySize(int nodeA,int nodeB){
            int parentA=findUpar(nodeA);
            int parentB=findUpar(nodeB);
            if(parentA==parentB) return;
            if(size.get(parentA)>size.get(parentB)){
                parent.set(parentB,parentA);
                size.set(parentB,size.get(parentA)+size.get(parentB));
            }
            else{
                parent.set(parentA,parentB);
                size.set(parentA,size.get(parentA)+size.get(parentB));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DSU dsu=new DSU(n);
        Map<String,Integer>map=new HashMap<>();//mail ,index
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(map.containsKey(accounts.get(i).get(j))){
                    dsu.UnionByRank(i,map.get(accounts.get(i).get(j)));
                }
                else{
                    map.put(accounts.get(i).get(j),i);
                }
            }
        }
        List<String>[] mergedAccounts=new List[n];
        for(int i=0;i<n;i++) mergedAccounts[i]=new ArrayList<>();
        for(Map.Entry<String,Integer>entry : map.entrySet()){
            String email=entry.getKey();
            int index=entry.getValue();
            int parent=dsu.findUpar(index);
            mergedAccounts[parent].add(email);
        }
        List<List<String>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<String>list=mergedAccounts[i];
            if(list.size()>0){
                Collections.sort(list);
                list.add(0,accounts.get(i).get(0));
                ans.add(list);
            }
        }
        return ans;
    }
}
