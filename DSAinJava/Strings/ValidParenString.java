package DSAinJava.Strings;

public class ValidParenString {
    public boolean checkValidString(String s) {
        int n=s.length();
        int open=0;
        int close=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('||s.charAt(i)=='*') open++;
            else open--;

            if(s.charAt(n-i-1)==')'||s.charAt(n-i-1)=='*') close++;
            else close--;

            if(open<0 || close<0) return false;
        }
        return true;
    }
}
