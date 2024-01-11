package DSAinJava.Strings;

public class BullsCows {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        int[] secretChars=new int[10];
        int[] guessChars=new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){//bull
                bulls++;
            }
            else{
                secretChars[secret.charAt(i)-'0']++;
                guessChars[guess.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<10;i++){
            cows+=Math.min(secretChars[i],guessChars[i]);
        }
        return bulls+"A"+cows+"B";
    }
}
