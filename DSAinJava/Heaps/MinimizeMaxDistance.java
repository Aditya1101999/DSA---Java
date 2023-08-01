package DSAinJava.Heaps;
import java.util.*;
public class MinimizeMaxDistance {
    static class Pair{
        double dis;
        int index;
        public Pair(double dis,int index){
            this.dis=dis;
            this.index=index;
        }
    }
    public static double findSmallestMaxDist(int stations[],int K) {
        int n=stations.length;
        int[] sectors=new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dis, a.dis));
        for(int i=0;i<n-1;i++){
            pq.add(new Pair(stations[i+1]-stations[i],i));
        }
        for(int i=0;i<K;i++){
            Pair curr=pq.poll();
            sectors[curr.index]++;//place station
            double dis=stations[curr.index+1]-stations[curr.index];
            double sectorLength=dis/(double)(sectors[curr.index]+1);
            pq.add(new Pair(sectorLength,curr.index));
        }
        return pq.peek().dis;
    }
}
