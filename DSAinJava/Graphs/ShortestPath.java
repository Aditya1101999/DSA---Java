package DSAinJava.Graphs;
import java.util.*;
class ShortestPath {
    static class Pair {
        int first;//dest
        int second;//weight

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
        private void dfs(int node, ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> st) {
            visited[node] = true;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                if (!visited[v]) {
                    dfs(v, adj, visited, st);
                }
            }
            st.push(node);
        }

        public int[] shortestPath(int N, int M, int[][] edges) {
            //step 1->convert matrix into list
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < N; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                adj.get(u).add(new Pair(v, wt));
            }
            //step 2->Topo Sort
            boolean[] visited = new boolean[N];
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    dfs(i, adj, visited, st);
                }
            }
            //step 3->Calculate minimum distance
            int[] dist = new int[N];
            for (int i = 0; i < N; i++) {
                dist[i] = (int) (1e9);//initializing array to infinity
            }
            dist[0] = 0;//src
            while (!st.isEmpty()) {
                int u = st.pop();
                for (int i = 0; i < adj.get(u).size(); i++) {
                    int v = adj.get(u).get(i).first;
                    int wt = adj.get(u).get(i).second;

                    if (dist[u] + wt < dist[v]) {//relaxing edges
                        dist[v] = dist[u] + wt;
                    }
                }
            }
            return dist;
        }
    public int[] shortestPathUnitDistances(int[][] edges,int n,int m ,int src) {
        //step 1->convert matrix into list
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){//connect each edge
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        //step 2-> bfs
        int[] dis=new int[n];
        for(int i=0;i<n;i++){
            dis[i] = (int) (1e9);//initializing array to infinity
        }
        Queue<Integer>q=new LinkedList<>();
        dis[src]=0;
        q.add(src);
        int wt=1;
        while(!q.isEmpty()){
            int u=q.remove();
            for(int v : graph.get(u)){
                if(dis[u]+wt<dis[v]){
                    dis[v]=dis[u]+wt;
                    q.add(v);
                }
            }
        }
        return dis;
    }
    }