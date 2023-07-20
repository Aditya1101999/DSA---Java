package DSAinJava.Stack;
import java.util.Stack;
public class AsterioidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<>();
        for(int asteroid : asteroids){
            if(asteroid>0){
                st.push(asteroid);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroid)){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(asteroid)){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0){
                    st.push(asteroid);
                }
            }
        }
        int n=st.size();
        int[] ans=new int[n];
        while(!st.isEmpty()){
            ans[n-1]=st.pop();
            n--;
        }
        return ans;
    }
}
