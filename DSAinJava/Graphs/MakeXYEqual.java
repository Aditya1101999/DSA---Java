package DSAinJava.Graphs;
import java.util.*;
public class MakeXYEqual {
    static class Pair{
        Integer key;
        Integer value;
        Pair(Integer key,Integer value){
            this.key=key;
            this.value=value;
        }
        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Pair>q=new LinkedList<>();
        Set<Integer>set=new HashSet<>();

        q.add(new Pair(x,0));//x, operations

        while(!q.isEmpty()){
            int value=q.peek().getKey();
            int operations=q.peek().getValue();
            q.poll();

            if(value==y){
                return operations;
            }
            if(value%11==0 && !set.contains(value/11)){
                q.add(new Pair(value/11 , operations+1));
                set.add(value/11);
            }
            if(value%5==0 && !set.contains(value/5)){
                q.add(new Pair(value/5 , operations+1));
                set.add(value/5);
            }
            if(!set.contains(value+1)){
                q.add(new Pair(value+1 , operations+1));
                set.add(value+1);
            }
            if(!set.contains(value-1)){
                q.add(new Pair(value-1 , operations+1));
                set.add(value-1);
            }
        }
        return -1;
    }
}
