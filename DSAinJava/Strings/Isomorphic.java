package DSAinJava.Strings;
import java.util.Arrays;
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        int[] sTot=new int[128];
        int[] tTos=new int[128];
        Arrays.fill(sTot,-1);
        Arrays.fill(tTos,-1);
        for(int i=0;i<s.length();i++){
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);

            if(sTot[sChar]==-1) sTot[sChar]=tChar;
            if(tTos[tChar]==-1) tTos[tChar]=sChar;

            if(sTot[sChar]!=tChar || tTos[tChar]!=sChar) return false;
        }
        return true;
    }
}
