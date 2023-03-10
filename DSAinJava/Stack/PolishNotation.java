package Stack;
import java.util.*;
public class PolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<String> st=new Stack<>();
        for(String el:tokens){
            if(el.equals("+")||el.equals("-")||el.equals("*")||el.equals("/")){
                int ans=0;
                int el2=Integer.parseInt(st.pop());
                int el1=Integer.parseInt(st.pop());
                if(el.equals("+")){
                    ans=el1+el2;
                }
                else if(el.equals("-")){
                    ans=el1-el2;
                }
                else if(el.equals("*")){
                    ans=el1*el2;
                }
                else if(el.equals("/")){
                    ans=el1/el2;
                }
                st.push(ans+"");
            }
            else{
                st.push(el);
            }
        }
        return Integer.parseInt(st.peek());
    }
    public static void main(String[] args){
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));

    }
}
