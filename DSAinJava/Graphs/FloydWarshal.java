package DSAinJava.Graphs;

public class FloydWarshal {
    public void shortest_distance(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){//just for comparing
                if(matrix[i][j]==-1) matrix[i][j]=Integer.MAX_VALUE;
                if(i==j) matrix[i][j]=0;//src
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){//try to go via every possible node
                    if (matrix[i][k] == Integer.MAX_VALUE ||
                            matrix[k][j] == Integer.MAX_VALUE)//no direct node
                        continue;
                    matrix[i][j]=Math.min(matrix[i][j],
                            matrix[i][k]+matrix[k][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[i][i]<0){
                //negative cycle exists , as source to source will have distance
                //as 0
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==Integer.MAX_VALUE) matrix[i][j]=-1;
            }
        }

    }
    boolean graph(int N, int adj[][])
    {
        int[][] graph=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                graph[i][j]=adj[i][j];
            }
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[j][k]);
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(adj[i][j]!=graph[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
