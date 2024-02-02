package DSAinJava.Queues;
import java.util.*;
public class SeqDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>ans=new ArrayList<>();
        // Queue<Integer>q=new LinkedList<>();
        // for(int i=1;i<9;i++){
        //     q.add(i);
        // }
        // while(!q.isEmpty()){
        //     int curr=q.poll();
        //     if(curr>high) break;

        //     if(curr>=low && curr<=high) ans.add(curr);
        //     int lastDigit=curr%10;
        //     if(lastDigit<9){
        //         int nextDigit=(curr*10)+(lastDigit+1);
        //         q.add(nextDigit);
        //     }
        // }
        List<Integer> allPossible = List.of(12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789);
        for(int el : allPossible){
            if(el<low) continue;
            else if(el>high) break;

            ans.add(el);
        }
        return ans;
    }
}
