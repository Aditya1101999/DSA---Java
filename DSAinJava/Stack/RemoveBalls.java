package DSAinJava.Stack;
import java.util.Stack;
public class RemoveBalls {
    public static int finLength(int N, int[] color, int[] radius) {
        Stack<int[]>st=new Stack<>();
        for(int i=0;i<color.length;i++){
            if(st.isEmpty()){
                st.push(new int[]{color[i],radius[i]});
            }
            else if(st.peek()[0]==color[i] && st.peek()[1]==radius[i]){
                st.pop();
            }
            else{
                st.push(new int[]{color[i],radius[i]});
            }
        }
        return st.size();
    }
}
