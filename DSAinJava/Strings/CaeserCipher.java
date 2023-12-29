package DSAinJava.Strings;
import java.util.*;
public class CaeserCipher {
    public static String rollingString(String s, List<String> operations) {
        for(String op :operations){
            String[] arr=op.split(" ");
            int index1=Integer.parseInt(arr[0]);
            int index2=Integer.parseInt(arr[1]);
            for(int i=index1;i<=index2;i++){
                if(arr[2].equals("L")){
                    s=replaceCharAtIndex(s, i, -1);
                }
                else{
                    s=replaceCharAtIndex(s, i, 1);
                }
            }
        }
        return s;
    }
    private static String replaceCharAtIndex(String input, int index, int change) {
        if (index < 0 || index >= input.length()) {
            // Index out of bounds
            return input;
        }

        char[] chars = input.toCharArray();
        char originalChar = chars[index];

        // If the change is -1, shift the character to the left
        if (change == -1) {
            chars[index] = originalChar == 'a' ? 'z' : (char) (originalChar - 1);
        }
        // If the change is 1, shift the character to the right
        else if (change == 1) {
            chars[index] = originalChar == 'z' ? 'a' : (char) (originalChar + 1);
        }

        return new String(chars);
    }
}
