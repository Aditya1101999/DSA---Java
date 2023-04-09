package Stack;
import java.util.*;
public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if (part.equals(".") || part.isEmpty()) continue;
                // skip current directory and empty parts
            else if (part.equals("..")) {
                // go up one level
                if (!stack.isEmpty()) stack.pop();
            } else {
                // add directory name to stack
                stack.push(part);
            }
        }
        // build canonical path from stack
        StringBuilder sb = new StringBuilder("/");
        while (!stack.isEmpty()) {//index 1->most recently added directory name appears first in the path
            sb.insert(1, stack.pop() + "/");// sb = "/baz/bar/foo/"
        }
        // remove trailing slash if not root directory
        if (sb.length() > 1 && sb.charAt(sb.length()-1) == '/') {
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String str = new String("/a/..");
        String res = simplifyPath(str);
        System.out.println(res);
    }
}
