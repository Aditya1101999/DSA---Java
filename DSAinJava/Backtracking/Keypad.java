package DSAinJava.Backtracking;
import java.util.*;
public class Keypad {
    static char[][] L = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}
            , {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    public static void letterCombo(String a) {
        int n = a.length();
        if (n == 0) {
            System.out.println("");
        }
        combo(0, n, new StringBuilder(), a);
    }
    public static void combo(int pos, int n, StringBuilder sb, String a) {
        if (pos == n) {//all permutations done
            System.out.println(sb.toString());
        } else {
 //converted string type to no. so that we can access it from L array
//e.g. "2" converted to 2 to access a,b,c
            char[] letters = L[Character.getNumericValue(a.charAt(pos))];
            for (int i = 0; i < letters.length; i++) {
                //recursion step
                combo(pos+1, n, new StringBuilder(sb).append(letters[i]), a);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] set={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String>ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        Helper(digits,set,ans,0,"");
        return ans;
    }
    private void Helper(String digits,String[] set,List<String>ans,int index,String currString){
        if(index==digits.length()){
            ans.add(currString);
            return;
        }
        String possibleChars=set[digits.charAt(index)-'0'];//retrieving index of the digit from set
        for(char c :possibleChars.toCharArray()){
            Helper(digits,set,ans,index+1,currString+c);
        }

    }
    public static void main(String[] args) {

        letterCombo("234");
    }
}