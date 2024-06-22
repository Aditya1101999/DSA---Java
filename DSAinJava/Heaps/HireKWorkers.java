package DSAinJava.Heaps;
import java.util.*;
public class HireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=quality.length;
        double[][] ratioQuality=new double[n][2];
        for(int i=0;i<n;i++){
            ratioQuality[i][0]=(1.0*wage[i])/quality[i];
            ratioQuality[i][1]=quality[i];
        }
        Arrays.sort(ratioQuality,(a,b)->Double.compare(a[0],b[0]));
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        double sum=0;
        double ans=Double.MAX_VALUE;
        for(double[] value : ratioQuality){
            sum+=value[1];
            pq.add((int)value[1]);
            if(pq.size()>k) sum-=pq.poll();
            if(pq.size()==k){
                double ratio =value[0];
                ans=Math.min(ans,sum*ratio);
            }
        }
        return ans;
    }
}
