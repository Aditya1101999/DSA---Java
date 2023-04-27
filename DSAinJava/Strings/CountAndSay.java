package DSAinJava.Strings;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s=countAndSay(n-1);

        StringBuilder res=new StringBuilder();
        int freq=0;
        for(int i=0;i<s.length();i++){
            freq++;
            if(i==s.length()-1||s.charAt(i)!=s.charAt(i+1)){
                res.append(freq).append(s.charAt(i));
                freq=0;
            }
        }
        return res.toString();
    }
}
