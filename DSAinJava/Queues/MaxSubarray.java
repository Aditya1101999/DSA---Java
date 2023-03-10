package Queues;
import java.util.*;
public class MaxSubarray {
    public static void printMax(int[] arr,int n,int k) {
        Deque<Integer> q = new LinkedList<>();
        int i;
        for (i = 0; i < k; ++i) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
//previous smaller useless elements are removed
        }
            //the first part of the
            //for statement was already set somewhere in the code
            for (; i < n; ++i) {//for rest elements
                System.out.print(arr[q.peek()] + " ");
                //element at the front is the largest element of previous window

                //removing elements which are not in this window
                while (!q.isEmpty() && q.peek() <= i - k) {
                    q.removeFirst();
                }
                //last element
                while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
                    System.out.print(arr[q.peek()]);
    }
    public static void main(String[] args){
        int[] arr={12,1,78,90,57,89,56};
        int k=3;
        printMax(arr,arr.length,k);
    }
}

