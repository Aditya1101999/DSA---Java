package DSAinJava.Heaps;
import java.util.*;
public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] profitCapital=new int[n][2];
        for(int i=0;i<n;i++){
            profitCapital[i][0]=profits[i];
            profitCapital[i][1]=capital[i];
        }
        Arrays.sort(profitCapital,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);//more profit
        int index=0;
        while(k-->0){
            while(index<n && profitCapital[index][1]<=w){
                pq.add(profitCapital[index++][0]);
            }
            if(pq.isEmpty()){
                break;
            }
            w+=pq.poll();
        }
        return w;
    }
}
