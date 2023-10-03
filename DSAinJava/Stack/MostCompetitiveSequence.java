package DSAinJava.Stack;
import java.util.Stack;
public class MostCompetitiveSequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer>st=new Stack<>();
        int elementsToBeRemoved=nums.length-k;
        for(int el : nums){
            while(!st.isEmpty() && elementsToBeRemoved>0 && st.peek()>el){
                st.pop();
                elementsToBeRemoved--;
            }
            st.push(el);
        }
        while(elementsToBeRemoved>0){
            st.pop();
            elementsToBeRemoved--;
        }
        int[] ans=new int[k];
        int index=0;
        for(int el : st){
            ans[index++]=el;
        }
        return ans;
    }
}
