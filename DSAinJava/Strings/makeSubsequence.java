package DSAinJava.Strings;

public class makeSubsequence {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n=str1.length();
        int i=0;
        int j=0;
        while(i<n){
            if(str1.charAt(i)==str2.charAt(j) || str1.charAt(i)+1==str2.charAt(j)|| (str1.charAt(i)=='z' && str2.charAt(j)=='a')){
                j++;
            }
            if(j==str2.length()) return true;
            i++;//i will be incremented in every case
        }
        return false;
    }
}
