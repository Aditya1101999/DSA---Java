package DSAinJava.Stack;
import java.util.Stack;
public class RemoveDuplicateChars {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        Stack<Integer>st=new Stack<>();
        int[] lastIndex=new int[26];
        boolean[] visited=new boolean[26];
        for(int i=0;i<n;i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            if(visited[c]) continue;

            visited[c]=true;
            while(!st.isEmpty() && st.peek()>c && lastIndex[st.peek()]>i){
                visited[st.pop()]=false;

            }
            st.push(c);
        }
        StringBuilder sb=new StringBuilder();
        for(int el : st){//iteration from start
            sb.append((char)(el+'a'));
        }
        return sb.toString();
    }
}
