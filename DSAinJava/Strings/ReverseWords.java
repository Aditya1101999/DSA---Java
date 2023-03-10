package Strings;

public class ReverseWords {
    public String reverseWords(String s) {
        int n=s.length();
        StringBuilder curr=new StringBuilder();
        String ans="";
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' '){
                curr.reverse();
                ans+=curr;
                ans+=' ';
                curr=new StringBuilder();//emptying curr
            }
            else{
                curr.append(s.charAt(i));
            }
        }
        curr.reverse();
        ans+=curr;
        return ans;
    }
}
