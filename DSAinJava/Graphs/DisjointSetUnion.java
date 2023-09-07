package DSAinJava.Graphs;
import java.util.*;
public class DisjointSetUnion {
    static class DisJoint{
        int[] parent;
        int[] rank;
        int[] size;
        public DisJoint(int n){
            parent=new int[n+1];
            for(int i=0;i<=n;i++){
                parent[i]=i;
            }
            rank=new int[n+1];
            size=new int[n+1];
            Arrays.fill(size,1);
        }
        public int findPar(int u){
            if(parent[u]==u){
                return u;
            }
            //path compression
            return parent[u]=findPar(parent[u]);
        }
        public void unionByRank(int u,int v){
            int pU=findPar(u);
            int pV=findPar(v);
            if(pU==pV) return;
            if(rank[pU]>rank[pV]){
                parent[pV]=pU;
            }
            else if(rank[pV]>rank[pU]){
                parent[pU]=pV;
            }
            else{//ranks are equal
                parent[pU]=pV;//or parent[pV]=pU , either ways works
                rank[pV]++;
            }
        }
        public void unionBySize(int u,int v){
            int pU=findPar(u);
            int pV=findPar(v);
            if(pU==pV) return;
            if(size[pU]>size[pV]){
                parent[pV]=pU;
                size[pU]+=size[pV];
            }
            else if(size[pU]<size[pV]){
                parent[pU]=pV;
                size[pV]+=size[pU];
            }
            else{
                parent[pU]=pV;//or parent[pV]=pU->size[pU]+=size[pV] , either ways works
                size[pV]+=size[pU];
            }
        }
    }

    public static void main(String[] args) {
        DisJoint ds=new DisJoint(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if (ds.findPar(3) == ds.findPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findPar(3) == ds.findPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
