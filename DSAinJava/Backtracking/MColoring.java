package DSAinJava.Backtracking;

public class MColoring {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colors=new int[n];
        return solve(0,graph,colors,m,n);
    }
    private boolean solve(int node,boolean[][] graph,int[] colors,int m,int n){
        if(node==n){
            return true;
        }
        for(int i=1;i<=m;i++){//colors
            if(isSafe(graph,colors,node,n,i)){
                colors[node]=i;
                if(solve(node+1,graph,colors,m,n)) return true;
                colors[node]=0;
            }
        }
        return false;
    }
    private boolean isSafe(boolean[][] graph,int[] colors,int node,int n,int i){
        for(int el=0;el<n;el++){//connected and of same color
            if(graph[node][el] && colors[el]==i) return false;
        }
        return true;
    }
}
