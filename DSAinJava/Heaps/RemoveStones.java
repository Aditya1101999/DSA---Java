package Heaps;
import java.util.PriorityQueue;
public class RemoveStones {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        for(int stones:piles){
            pq.add(stones);
        }
        while(k-->0){
            int curr=pq.remove();
            int oper=(int)Math.floor(curr/2);
            pq.add(curr-oper);
        }
        int res=0;
        while(!pq.isEmpty()){
            int curr=pq.remove();
            res+=curr;
        }
        return res;
    }
    public static void main(String[] args){
        int[] piles={5,4,9};
        int k=2;
        System.out.println(minStoneSum(piles,k));
    }
}
