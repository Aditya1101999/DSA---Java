package DSAinJava.Heaps;
import java.util.*;
public class KPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        //fraction , numIndex , denIndex
        PriorityQueue<double[]>pq=new PriorityQueue<>((a,b)->Double.compare(a[0],b[0]));
        for(int i=0;i<n-1;i++){
            double fraction=1.0*arr[i]/arr[n-1];
            pq.add(new double[]{fraction,i,n-1});
        }
        // maintain the smallest fraction possible from every numerator
        int numIndex=-1;
        int denIndex=-1;
        while(k-->0){
            numIndex=(int)pq.peek()[1];
            denIndex=(int)pq.peek()[2];
            pq.poll();
            if(numIndex<denIndex-1){
                double fraction=1.0*arr[numIndex]/arr[denIndex-1];
                pq.add(new double[]{fraction,numIndex,denIndex-1});
            }
        }
        return new int[]{arr[numIndex],arr[denIndex]};
    }
}
