package Strings;

public class Palindrome {
    public static boolean palindrome_string(String str){
        for(int i=0;i<str.length()/2;i++) {//TC=O(N)
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                //not palindrome
                return false;
            }
        }
        return true;

        }

    public static void main(String args[]){
        String str="racecar";
        System.out.println(palindrome_string(str));
    }
}
