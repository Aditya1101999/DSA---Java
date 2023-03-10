package Heaps;
import java.util.PriorityQueue;

public class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        minHeap=new PriorityQueue<>();
        for(int el:nums){
            add(el);
        }
    }
    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size()>k){
            minHeap.remove();
        }
        return minHeap.peek();

    }
    public static void main(String[] args){
        int[] nums = {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;
        KthLargest obj = new KthLargest(k, nums);
        int param_1 = obj.add(5);
    }

}
