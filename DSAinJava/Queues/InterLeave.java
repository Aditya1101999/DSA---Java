package Queues;
import java.util.*;
public class InterLeave {
    public static void interLeave(Queue<Integer>q){
        Queue<Integer> firstHalf=new LinkedList<>();
        int size=q.size();

        //first half
        for(int i=0;i<size/2;i++){
//Note-Do not write q.size()/2 ,
// since its value changes after every iteration
            firstHalf.add(q.remove());
        }
        //making interleaf
        while(!firstHalf.isEmpty()){
            //adding one first half element
            q.add(firstHalf.remove());
//and then adding one second half element consecutively
            q.add(q.remove());
        }
    }
    public static void main(String[] args){
        Queue<Integer>q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interLeave(q);
        //print Q
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
}
