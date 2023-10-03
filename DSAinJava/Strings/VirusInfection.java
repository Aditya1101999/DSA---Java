package DSAinJava.Strings;

public class VirusInfection {
    int solve(String s, int K)
    {
        char[] arr=s.toCharArray();
        int n=arr.length;
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(arr[i]=='1' && !visited[i]){
                count+=bfs(i,visited,arr,K);
            }
        }
        return count;
    }
    int bfs(int index,boolean[] visited,char[] arr,int k){
        visited[index]=true;
        int count=1;
        for(int i=index+1;i<=index+k && i<arr.length;i++){
            if(!visited[i] && arr[i]=='0'){
                visited[i]=true;
                count++;
            }
            else{
                break;
            }
        }
        for(int i=index-1;i>=index-k && i>=0;i--){
            if(!visited[i] && arr[i]=='0'){
                visited[i]=true;
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}

