package Heaps;
import java.util.*;
public class FillSlots {
    public static int minTime(int n,int k,int[] arr){
            Queue<Integer>q=new LinkedList<>();
            boolean[] visited=new boolean[n+1];
            for(int i=0;i<k;i++){
                q.add(arr[i]);
                visited[i]=true;
            }
            int time=0;
            while(q.size()>0) {
                for(int i=0;i<q.size();i++) {
                    int curr = q.remove();//indices which are filled
                    if (curr - 1 >= 1 && !visited[curr - 1]) {
                        q.add(curr - 1);
                        visited[curr - 1] = true;
                    }
                    if (curr + 1 <= n && !visited[curr + 1]) {
                        q.add(curr + 1);
                        visited[curr + 1] = true;
                    }
                }
                time++;
            }
            return time-1;
    }
    public static void main(String[] args) {
        int N = 6;
        int arr[] = {2, 6};
        int K = 2;
        System.out.println(minTime(N,K,arr));
    }
}
