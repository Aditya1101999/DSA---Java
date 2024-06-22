package DSAinJava.Recursion;
import java.util.*;
public class JugglerSeq {
    static List<Integer> jugglerSequence(int n) {
        List<Integer>ans=new ArrayList<>();
        Helper(n,ans);
        return ans;
    }
    static void Helper(int n,List<Integer>ans){
        if(n==1){
            ans.add(n);
            return;
        }
        ans.add(n);
        if(n%2==0){//even
            n=(int)Math.sqrt(n);
        }
        else{
            n=(int)(Math.sqrt(n) * n);
        }
        Helper(n,ans);
    }
}
