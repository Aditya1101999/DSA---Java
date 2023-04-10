package DSAinJava.Stack;
import java.util.*;
public class FreqStack {
    List<Stack<Integer>>stList;
    Map<Integer,Integer>map;//el,freq
    public FreqStack() {
        map=new HashMap<>();
        stList=new ArrayList<>();
    }

    public void push(int x) {
        map.put(x,map.getOrDefault(x,0)+1);
        int freq=map.get(x);
        if(freq-1>=stList.size()){
            stList.add(new Stack<>());
        }
        stList.get(freq-1).push(x);
    }

    public int pop() {
        int size=stList.size();
        int x=stList.get(size-1).pop();
        if(stList.get(size-1).isEmpty()){
            stList.remove(stList.get(size-1));
        }
        map.put(x,map.get(x)-1);
        return x;
    }
}