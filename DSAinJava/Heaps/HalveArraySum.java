package Heaps;
import java.util.*;
import java.util.PriorityQueue;

public class HalveArraySum {
    public static int halveArray(int[] nums) {
        Queue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0, cur = 0;
        for(int val : nums){
            sum += val;
            pq.add((double)val);
        }
        int count = 0;
        while(cur < sum/2) {
            double val = pq.remove()/2;
            cur += val;
            pq.add(val);
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums ={5,19,8,1};
        System.out.println(halveArray(nums));
    }

}
