package DSAinJava.Stack;
import java.util.Stack;
public class MinStack {
    private Stack<int[]>st;//value,minValue

    public MinStack() {
        st=new Stack<>();
    }

    public void push(int val) {
        if(!st.isEmpty()){
            int[] top=st.peek();
            int min=Math.min(val,top[1]);
            st.push(new int[]{val,min});
        }
        else{
            st.push(new int[]{val,val});
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        int[] top=st.peek();
        return top[0];
    }

    public int getMin() {
        int[] top=st.peek();
        return top[1];
    }
}