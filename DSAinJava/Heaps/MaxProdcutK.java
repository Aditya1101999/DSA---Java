package DSAinJava.Heaps;
import java.util.PriorityQueue;
public class MaxProdcutK {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int el : nums){
            pq.add(el);
        }
        while(k-->0){
            pq.add(pq.poll()+1);
        }
        long ans=1;
        int mod=(int)1e9+7;
        while(!pq.isEmpty()){
            ans=(ans*pq.poll())%mod;
        }
        return (int)ans;
    }
}

