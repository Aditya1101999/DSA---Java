package DSAinJava.Strings;

public class findDifference {
    //we can also use xor in place of addition and subtraction
    public char findTheDifference(String s, String t) {
        int sum=0;
        for(char c : t.toCharArray()) sum+=c;
        for(char c : s.toCharArray()) sum-=c;
        return (char)sum;
    }
    //append to s so that t is the subsequence of s
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        int count=0;
        while(i<s.length() && j<t.length()){//find initial matching characters
            if(s.charAt(i)==t.charAt(j)){
                count++;
                j++;
            }
            i++;
        }

        return t.length()-count;
    }
}
