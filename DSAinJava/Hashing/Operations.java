package Hashing;
import java.util.*;
public class Operations {
    public static void main(String[] args){
        HashMap<String,Integer>map=new HashMap<>();
        map.put("INDIA",100);
        map.get("INDIA");
        map.containsKey("INDIA");
        map.remove("india");
        map.size();
        map.isEmpty();
        map.clear();
        //keyset
        Set<String>keys=map.keySet();
        //map.entrySet();
        for(String k:keys){
            System.out.println("key="+k+"value="+map.get(k));
        }
    }

}
