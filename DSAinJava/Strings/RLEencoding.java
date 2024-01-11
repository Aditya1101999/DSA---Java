package DSAinJava.Strings;

public class RLEencoding {
    String encode(String str)
    {
        StringBuilder sb=new StringBuilder();
        int currFreq=1;
        char currChar=str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                sb.append(str.charAt(i-1));
                sb.append(currFreq);
                currChar=str.charAt(i);
                currFreq=1;
            }
            else{
                currFreq++;
            }
        }
        sb.append(currChar);
        sb.append(currFreq);
        return sb.toString();
    }
}
