package DSAinJava.Graphs;
import java.util.*;
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String>set=new HashSet<>(Arrays.asList(deadends));
        String start="0000";
        if(set.contains(start)) return -1;
        Queue<String>q=new LinkedList<>();
        q.add(start);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String curr=q.poll();
                if(curr.equals(target)) return level;
                //bfs
                for(int i=0;i<4;i++){
                    char[] front=curr.toCharArray();
                    //increase
                    front[i]= front[i]=='9' ? '0' : (char) (front[i] + 1);
                    String increase=new String(front);
                    if(!set.contains(increase)){
                        q.add(increase);
                        set.add(increase);
                    }
                    char[] back= curr.toCharArray();
                    //decrease
                    back[i]=back[i]=='0' ? '9' : (char) (back[i] - 1);
                    String decrease=new String(back);
                    if(!set.contains(decrease)){
                        q.add(decrease);
                        set.add(decrease);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
