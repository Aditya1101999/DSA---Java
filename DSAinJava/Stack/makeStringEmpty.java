package DSAinJava.Stack;
import java.util.Stack;
public class makeStringEmpty {
    static int makeEmpty(String s) {
        Stack<StringBuilder> st=new Stack<>();
        String geek="geek";
        int count=0;
        if(s.charAt(0)!='g') return -1;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr=='g'){
                StringBuilder sb=new StringBuilder();
                sb.append(curr);
                st.push(sb);
            }
            else{
                StringBuilder temp=st.pop();
                temp.append(curr);
                st.push(temp);
            }
            if(!st.isEmpty() && st.peek().toString().equals(geek)){
                st.pop();
                count++;
            }
        }
        return st.isEmpty() ? count : -1;
    }
}
