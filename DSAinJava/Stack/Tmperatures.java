package Stack;
import java.util.*;
public class Tmperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() &&temperatures[i]>temperatures[st.peek()]){
                int index=st.pop();
                res[index]=i-index;
            }
            st.push(i);

        }
        return res;
    }
    public static void main(String[] args){
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res=dailyTemperatures(temperatures);
        for(int temp:res){
            System.out.print(temp+" ");
        }
    }
}
