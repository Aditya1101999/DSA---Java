package DSAinJava.Queues;
import java.util.*;
public class ArrayGame {
    public static int min_operations(int n, int[] arr, int[] brr) {
        Queue<Integer>q=new LinkedList<>();
        int index=0;
        int op=0;
        for(int el:arr){
            q.add(el);
        }
        while(!q.isEmpty()){
            while(q.peek()!=brr[index]){
                int curr=q.remove();
                q.add(curr);
                op++;
            }
            q.remove();
            op++;
            index++;
        }
        return op;
    }
}
