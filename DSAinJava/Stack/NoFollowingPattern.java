package DSAinJava.Stack;
import java.util.Stack;
public class NoFollowingPattern {
    static String printMinNumberForPattern(String s){
        Stack<Integer>st=new Stack<>();
        int num=1;
        StringBuilder ans=new StringBuilder();
        for(char c : s.toCharArray()){
            st.push(num);
            num++;
            if(c=='I'){
                while(!st.isEmpty()){
                    ans.append(st.pop());
                }
            }
        }
        ans.append(num);
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
}
