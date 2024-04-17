package DSAinJava.Queues;
import java.util.*;
public class RevealCards {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n=deck.length;
        Queue<Integer>q=new LinkedList<>();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            q.add(i);
        }
        for (int card : deck) {
            int index = q.poll();

            result[index] = card;
            // if(!q.isEmpty())
            q.add(q.poll());
        }
        return result;
    }
}
