package DSAinJava.Strings;
import java.util.Arrays;
public class minLengthEncoding {
    //brute way -> create a set of words and for each string check each substring , if found remove it from set , final answer will be length of all str in set+set.size(for the #)
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(a,b)->b.length()-a.length());
        StringBuilder ans=new StringBuilder();
        for(String word : words){
            if(ans.indexOf(word+"#")==-1){
                ans.append(word).append("#");
            }
        }
        return ans.length();
    }
}
