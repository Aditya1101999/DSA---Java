package Stack;
import java.util.*;
public class RevStr {
    public static String reverseString(String str){
        Stack<Character>s=new Stack<>();
        int idx=0;
        //pushing characters in stack
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        //popping out characters in reverse order
        StringBuilder result=new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void main(String[] args){
        String str="abc";
        System.out.println(reverseString(str));
    }
}
