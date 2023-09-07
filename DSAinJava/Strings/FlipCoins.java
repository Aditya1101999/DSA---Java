package DSAinJava.Strings;

public class FlipCoins {
    public String flipCoins(int N,String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='0') count++;
        }
        if(count%2!=0) return "No";
        return "Yes";
    }
}
