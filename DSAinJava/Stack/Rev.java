package Stack;
import java.util.*;
public class Rev {
    public static void pushAtBottom(Stack<Integer> s,int data){
        //base case
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        //emptying elements
        int top=s.pop();
        pushAtBottom(s,data);
        //again filling elements
        s.push(top);
    }
    public static void revStack(Stack<Integer> s){
        //base case
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        revStack(s);
        pushAtBottom(s,top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s);
        revStack(s);
        System.out.println(s);
    }
}
