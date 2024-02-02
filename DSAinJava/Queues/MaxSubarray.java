package Queues;
import java.util.*;
public class MaxSubarray {
    public static int[] printMax(int[] a,int n,int k) {
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] <= a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
    public static void main(String[] args){
        int[] arr={12,1,78,90,57,89,56};
        int k=3;
        printMax(arr,arr.length,k);
    }
}

