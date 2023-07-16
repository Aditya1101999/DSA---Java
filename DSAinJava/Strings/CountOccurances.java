package DSAinJava.Strings;

public class CountOccurances {
    public int maxInstance(String s) {
        int b=0;
        int a=0;
        int l=0;
        int o=0;
        int n=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b') b++;
            else if(s.charAt(i)=='a') a++;
            else if(s.charAt(i)=='l') l++;
            else if(s.charAt(i)=='o') o++;
            else if(s.charAt(i)=='n') n++;
        }
        int min1=Math.min(b,Math.min(a,n));
        if(min1*2>=Math.min(l,o)) return (Math.min(l,o))/2;
        return min1;

    }
}
