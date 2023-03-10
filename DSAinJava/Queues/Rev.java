package Queues;
import java.util.*;
//using stack for queue reversing
public class Rev {
    public static void reverse(Queue<Integer> q){
        Stack<Integer>s=new Stack<>();

        while(!q.isEmpty()){//pushing elements into stack
            s.push(q.remove());
        }
        //pushing elements back in rev order
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args){
        Queue<Integer>q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        //print Q
        while (!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
}
