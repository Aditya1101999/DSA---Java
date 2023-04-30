package Strings;

public class ReverseWords {
    /*reverse each word in string i.e.
    "the sky is blue"->"eht yks si eulb"
     */
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
    /*reverse the order of each word in string i.e.
    "the sky is blue"->"blue is sky the"
     */
    public String reverseWords2(String s) {
        char[] letters=s.toCharArray();
        int n=letters.length;
        //reverse complete string
        reverse(letters,0,n-1);
        //reverse each word
        reverseWords(letters,n);
        //remove trailing or leading extra spaces
        return removeSpaces(letters,n);
    }
    private void reverse(char[] letters,int i,int j){
        while(i<j){
            char temp=letters[i];
            letters[i++]=letters[j];
            letters[j--]=temp;
        }
    }
    private void reverseWords(char[] letters,int n){
        int i=0;
        int j=0;
        //we have to ensure that i is the starting index of any word & j is the ending index of same word
        while(i<n){
            while(i<j||i<n && letters[i]==' ') i++;//skip trailing spaces and last word's last index
            while(j<i||j<n && letters[j]!=' ') j++;//skip the word and reach the end of the word
            reverse(letters,i,j-1);
        }
    }
    private String removeSpaces(char[] letters,int n){
        int i=0;
        int j=0;
        //j is for traversing complete string and i will ignore the spaces
        while(j<n){
            while(j<n && letters[j]==' ') j++;//trailing spaces
            while(j<n && letters[j]!=' ') letters[i++]=letters[j++];
            while(j<n && letters[j]==' ') j++;//leading spaces
            if(j<n) letters[i++]=' ';//1 valid space
        }
        return new String(letters).substring(0,i);
    }
}
