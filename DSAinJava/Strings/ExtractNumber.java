package DSAinJava.Strings;

public class ExtractNumber {
    long ExtractNum(String sentence) {
        long max=0;
        String[] words=sentence.split(" ");
        for(String word : words){
            if(Character.isDigit(word.charAt(0))){
                max=Math.max(max,toNumber(word));
            }
        }
        return max;
    }
    private long toNumber(String word){
        long ans=0;
        for(char c : word.toCharArray()){
            if(c=='9') return -1;
            ans=ans*10+c-'0';
        }
        return ans;
    }
}
