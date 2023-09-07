package DSAinJava.Stack;
import java.util.*;
public class maximum_energy {
    public static long maximumEnergy(int n, int[] heights) {
        int[] nextGreater=new int[n];
        Arrays.fill(nextGreater,-1);
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]>heights[st.peek()]){
                nextGreater[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }
        long[] dp=new long[n];
        for(int i=n-1;i>=0;i--){
            if(nextGreater[i]==-1){
                dp[i]=heights[i];
            }
            else dp[i] = heights[i] ^ dp[nextGreater[i]];
        }
        long max=0;
        for(long el:dp){
            max=Math.max(max,el);
        }
        return max;
    }
}
