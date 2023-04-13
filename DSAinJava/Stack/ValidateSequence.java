package DSAinJava.Stack;
import java.util.Stack;
public class ValidateSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>st=new Stack<>();
        int s=0;
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek()==popped[s]){
                st.pop();
                s++;
            }
        }
        return st.isEmpty();
    }
}
