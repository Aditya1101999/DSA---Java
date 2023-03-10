package Queues;
import java.util.*;
public class RevK {
    public static Queue<Integer> modifyQueue(Queue<Integer>q,int k){
        Stack<Integer>s=new Stack<>();
        int shift=k;
        while(k-->0){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        int temp=q.size()-shift;
        while(temp-->0){
            q.add(q.remove());
        }
        return q;
    }
    public static void main(String[] args){
        Queue<Integer>q=new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        System.out.print(modifyQueue(q,5));
    }
}
