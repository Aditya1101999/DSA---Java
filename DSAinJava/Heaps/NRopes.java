package Heaps;
import java.util.*;
import java.util.PriorityQueue;

public class NRopes {
    public static int minCost(int[] arr,int n){
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        int res=0;
        while(pq.size()>1){
            int first=pq.remove();
            int second=pq.remove();
            res+=first+second;
            pq.add(first+second);
        }
        return res;
    }
    public static void main(String[] args){
        int[] len={4,3,2,6};
        int size=len.length;
        System.out.println(minCost(len,size));
    }
}
