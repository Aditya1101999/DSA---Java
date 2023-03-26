package DSAinJava.Stack;
import java.util.*;
public class SortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        sortStack(s);
        return s;
    }
    void sortStack(Stack<Integer>s){
        if(s.size()==1) return;
        int temp=s.pop();
        sortStack(s);
        insert(temp,s);
    }
    void insert(int temp,Stack<Integer>s){
        if(s.isEmpty()||s.peek()<=temp){
            s.push(temp);
            return;
        }
        int top=s.pop();
        insert(temp,s);
        s.push(top);
    }
}
