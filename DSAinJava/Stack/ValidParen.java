package Stack;
import java.util.*;
public class ValidParen {
    public static boolean isValid(String str){
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            //opening
            if(ch=='('||ch=='{'||ch=='['){
                s.push(ch);
            }
            //closing
            else{
                if(s.isEmpty()){
                    return false;
                }
                //pair formed
                if((s.peek()=='(' && ch==')')
                    ||(s.peek()=='{' && ch=='}')
                        ||(s.peek()=='['&& ch==']')){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }
    public int longestValidParentheses(String s) {
        if(s.length()<2) return 0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){//opening braces
                st.push(i);
            }
            else{//closing braces
                if(!st.isEmpty() && s.charAt(st.peek())=='('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
            }
        }
        //after this loop , we will be left with invalid indices in stack
        int max=0;
        int end=s.length();
        while(!st.isEmpty()){
            int start=st.pop();
            max=Math.max(max,end-start-1);//we will have valid parantheses in between
            //-1 bcoz we have 0-based indexing
            end=start;
        }
        return Math.max(max,end);//last invalid index, as it won't be hit in the loop
    }
    public int longestValidParentheses2(String s) {//optimized
        int left=0;
        int right=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) max=Math.max(max,2*left);
            else if(right>left) left=right=0;
        }
        left=right=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) max=Math.max(max,2*left);
            else if(left>right) left=right=0;
        }
        return max;
    }

    public static void main(String[] args){
        String str="({})[]";
        System.out.println(isValid(str));
    }
}
