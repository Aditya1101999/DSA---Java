package DSAinJava.Greedy;
import java.util.Arrays;
public class TokenScore {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left=0;
        int right=tokens.length-1;
        int score=0;
        int max=0;
        while(left<=right){
            if(power>=tokens[left]){
                power-=tokens[left++];
                score++;
                max=Math.max(score,max);
            }
            else if(score!=0){
                power+=tokens[right--];
                score--;
            }
            else{
                return max;
            }
        }
        return max;
    }
}
