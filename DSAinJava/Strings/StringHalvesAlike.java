package DSAinJava.Strings;

public class StringHalvesAlike {
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int i=0;
        int mid=n/2;
        int j=mid;
        int vowelsfirstHalf=0;
        int vowelsSecondHalf=0;
        while(i<mid && j<n){
            if(isVowel(s.charAt(i))) vowelsfirstHalf++;
            if(isVowel(s.charAt(j))) vowelsSecondHalf++;

            i++;j++;
        }
        return vowelsfirstHalf==vowelsSecondHalf;
    }
    private boolean isVowel(char c){
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
                c=='A'||c=='E'||c=='I'||c=='O'||c=='U');
    }
}
