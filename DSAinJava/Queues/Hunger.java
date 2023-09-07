package DSAinJava.Queues;
import java.util.*;
public class Hunger {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(sc.nextInt());
        }
        int[] parathas=new int[n];
        for(int i=0;i<n;i++){
            parathas[i]=sc.nextInt();
        }
        int index=0;
        int counter=0;
        while(!q.isEmpty()){
            if(parathas[index]==q.peek()){
                index++;
                q.remove();
                counter=0;
            }
            else{
                q.add(q.remove());
                counter++;
            }
            if(counter==n) break;
        }
        System.out.println(q.size());
    }
}
