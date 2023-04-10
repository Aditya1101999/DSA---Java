package DSAinJava.Stack;
import java.util.*;
public class BasicCalculator {
    public int calculate(String s) {
        int n=s.length();
        int sign=1;
        int ans=0;
        int curr=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(Character.isDigit(s.charAt(i))){
                curr=s.charAt(i)-'0';
                while(i+1<n && Character.isDigit(s.charAt(i+1))){
                    curr=curr*10+s.charAt(i+1)-'0';
                    i++;
                }
                curr*=sign;
                ans+=curr;
                curr=0;
                sign=1;
            }
            else if(s.charAt(i)=='+'){
                sign=1;
            }
            else if(s.charAt(i)=='-'){
                sign=-1;
            }
            else if(s.charAt(i)=='('){
                st.push(ans);
                st.push(sign);
                ans=0;
                sign=1;
            }
            else if(s.charAt(i)==')'){
                int prevSign=st.pop();
                ans*=prevSign;
                int prevAns=st.pop();
                ans+=prevAns;
            }
        }
        return ans;
    }
    public int calculateTwo(String s) {//multiplication and division also
        int n=s.length();
        Stack<Integer>st=new Stack<>();
        int prevSign='+';
        int curr=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                curr=curr*10+(c-'0');
            }
            if(isOperator(c)||i==s.length()-1){
                if(prevSign=='+'){
                    st.push(curr);
                }
                else if(prevSign=='-'){
                    st.push(-curr);
                }
                else if(prevSign=='*'){
                    int top=st.pop();
                    curr*=top;
                    st.push(curr);
                }
                else if(prevSign=='/'){
                    int top=st.pop();
                    curr=top/curr;
                    st.push(curr);
                }
                curr=0;
                prevSign=c;
            }
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
    private boolean isOperator(Character c){
        return c=='+'||c=='-'||c=='*'||c=='/';
    }
}
