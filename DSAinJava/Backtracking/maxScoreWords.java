package DSAinJava.Backtracking;
import java.util.Arrays;
public class maxScoreWords {
    public int maxScore(String[] words, char[] letters, int[] score) {
        int[] freq=new int[26];
        for(char c : letters){
            freq[c-'a']++;
        }
        return scoreHelper(0,words,freq,score,0);
    }
    private int scoreHelper(int index, String[] words,int[] freq,int[] score,int currScore){
        if(index==words.length){
            return currScore;
        }
        int i=0;
        int tempScore=0;
        int[] tempFreq = Arrays.copyOf(freq, freq.length);
        while(i<words[index].length()){
            char c=words[index].charAt(i);
            tempFreq[c-'a']--;
            tempScore+=score[c-'a'];
            if(tempFreq[c-'a']<0) break;
            i++;
        }
        int include=0;
        if(i==words[index].length()){//can include
            include=scoreHelper(index+1,words,tempFreq,score,currScore+tempScore);
        }
        //not include
        int exclude=scoreHelper(index+1,words,freq,score,currScore);
        return Math.max(include,exclude);
    }
}
