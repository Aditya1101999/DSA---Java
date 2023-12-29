package DSAinJava.Strings;
import java.util.*;
public class SubstringRepetation {
    int kSubstrConcat(int n, String s, int k) {
        if(n%k!=0) return 0;

        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<n;i+=k){
            String subString=s.substring(i,i+k);
            map.put(subString,map.getOrDefault(subString,0)+1);
        }
        if(map.size()==1) return 1;
        boolean flag=false;
        if(map.size()==2){
            for(Map.Entry<String,Integer>entry:map.entrySet()){
                if(entry.getValue()==1) flag=true;
            }
        }
        return flag ? 1 : 0;
    }
}
