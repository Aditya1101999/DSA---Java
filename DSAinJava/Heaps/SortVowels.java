package DSAinJava.Heaps;
import java.util.*;
public class SortVowels {
    public String sortVowels(String s) {
        char[] charArray=s.toCharArray();
        PriorityQueue<Character> vowelsPriorityQueue = new PriorityQueue<>((a, b) -> a - b);
        for (int i=0;i<charArray.length;i++) {
            char ch=charArray[i];
            if (isVowel(ch)) {
                vowelsPriorityQueue.add(ch);
            }
        }
        for(int i=0;i<charArray.length;i++){
            char ch=charArray[i];
            if (isVowel(ch)) {
                charArray[i]=vowelsPriorityQueue.remove();
            }
        }
        return new String(charArray);
    }
    private static boolean isVowel(char ch) {
        char lowerCh = Character.toLowerCase(ch);
        return lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u';
    }
}
