package DSAinJava.Graphs;

public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited=new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }
    private void dfs(int i,boolean[] visited,int[][] isConnected){
        visited[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                visited[j]=true;
                dfs(j,visited,isConnected);
            }
        }
    }
}
