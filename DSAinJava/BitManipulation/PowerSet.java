package DSAinJava.BitManipulation;
import java.util.*;
public class PowerSet {
    public static List<String> AllPossibleStrings(String s)
    {
        int n=s.length();
        ArrayList<String>ans=new ArrayList<>();
        for(int i=0;i<(1<<n);i++){//i<2^n
            String str="";
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    str+=s.charAt(j);
                }
            }
            if(str.length()>0) ans.add(str);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> ans = (ArrayList<String>) AllPossibleStrings(s);
        //printint all the subsequence.
        System.out.println("All possible subsequences are ");
        for (String it : ans) {
            System.out.print(it + " ");
        }
    }
}

