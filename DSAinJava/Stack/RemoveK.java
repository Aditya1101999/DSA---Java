package DSAinJava.Stack;
import java.util.*;
public class RemoveK {
    public String removeKdigits(String num, int k) {
        Stack<Character>st=new Stack<>();
        for(char c : num.toCharArray()){
            while(!st.isEmpty() && st.peek()>c && k>0){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length()>0 ? sb.toString() : "0";
    }
}
