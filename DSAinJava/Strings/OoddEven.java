package DSAinJava.Strings;

public class OoddEven {
    public static String oddEven(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            freq[c-'a']++;
        }
        int x=0;
        int y=0;
        for(int i=0;i<26;i++){//i+1 is an alphabet
            if(freq[i]>0 && freq[i]%2==0 && (i+1)%2==0) x++;
                // lets say b has an even freq , so i+1 i.e. 1+1
            else if(freq[i]%2==1 && (i+1)%2==1) y++;
        }
        return ((x+y)%2==0) ? "EVEN" : "ODD";
    }
}
