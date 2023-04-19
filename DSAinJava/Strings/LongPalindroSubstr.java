package DSAinJava.Strings;

public class LongPalindroSubstr {
    int maxLength=0;
    int start=0;
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<=1) return s;
        for(int i=0;i<n;i++){
            checkforPalindromicSubstring(s,i,i);//odd length palindromic substring
            checkforPalindromicSubstring(s,i,i+1);//even length palindromic substring
        }
        return s.substring(start,start+maxLength);
    }
    private void checkforPalindromicSubstring(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if(right-left-1>maxLength){
            maxLength=right-left-1;
            start=left+1;
        }
    }
    int count=0;
    public int countSubstrings(String s) {
        int n=s.length();
        if(n<=1) return n;
        for(int i=0;i<n;i++){
            checkforPalindromicSubstring2(s,i,i);//odd length palindromic substring
            checkforPalindromicSubstring2(s,i,i+1);//even length palindromic substring
        }
        return count;
    }
    private void checkforPalindromicSubstring2(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }
}
