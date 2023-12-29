package DSAinJava.Hashing;
import java.util.*;
public class ElectionWinner {
    public static String[] winner(String arr[], int n)
    {
        Map<String,Integer>map=new HashMap<>();
        for(String str : arr){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int max=0;
        String ans="";
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            if(max<entry.getValue()){
                max=entry.getValue();
                ans=entry.getKey();
            }
            else if(max==entry.getValue()){
                if(entry.getKey().compareTo(ans)<0){
                    ans=entry.getKey();
                }
            }
        }
        return new String[]{ans,Integer.toString(max)};
    }
}
