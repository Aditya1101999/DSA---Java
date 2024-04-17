package DSAinJava.Strings;

public class NestingDepthVPS {
    public int maxDepth(String s) {
        int braces=0;
        int max=0;
        for(char c : s.toCharArray()){
            if(c=='(') braces++;
            if(c==')') braces--;
            max=Math.max(max,braces);
        }
        return max;
    }
}
