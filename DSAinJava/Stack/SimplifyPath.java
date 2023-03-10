package Stack;
import java.util.*;
public class SimplifyPath {
    public static String simplify(String str){
        Stack <String> s=new Stack<>();
        String res="";
        res+="/";
        for(int i=0;i<str.length();i++){
            String dir="";
            while(i<str.length()&&str.charAt(i)=='/'){
                i++;//skip
            }
            while(i<str.length()&&str.charAt(i)!='/') {
                //adding the character to directory
                dir += str.charAt(i);
                i++;

                if (dir.equals("..")) {
                    //parent directory
                    if (!s.isEmpty()) {
                        //current directory popped
                        s.pop();
                    }
                } else if (dir.equals(".")) {
                    //current directory
                    continue;
                    //skip '.' and continue with next iteration
                } else if (dir.length() != 0) {
                    //pushed directory into stack
                    s.push(dir);
                }
            }
            Stack<String> s1=new Stack<>();
            while(!s.isEmpty()){
                //copying elements in another stack
                //with right order
                s1.push(s.pop());
            }
            while(!s1.empty()){
                if(s1.size()!=1){
                    res+=(s1.pop()+"/");
                }
                else{//only / in result
                    res+=s1.pop();
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        String str = new String("/a/..");
        String res = simplify(str);
        System.out.println(res);
    }
}
