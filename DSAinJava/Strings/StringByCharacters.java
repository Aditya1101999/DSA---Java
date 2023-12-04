package DSAinJava.Strings;

public class StringByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] freq=new int[26];
        for(char c : chars.toCharArray()){
            freq[c-'a']++;
        }
        int answer=0;
        for(String word : words){
            int[] wordFreq=new int[26];
            for(char c : word.toCharArray()){
                wordFreq[c-'a']++;
            }
            boolean good=true;
            for(int i=0;i<26;i++){
                if(wordFreq[i]>freq[i]){
                    good=false;
                    break;
                }
            }
            if(good) answer+=word.length();
        }
        return answer;
    }
}
