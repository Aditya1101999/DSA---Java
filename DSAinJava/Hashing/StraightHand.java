package DSAinJava.Hashing;
import java.util.*;
public class StraightHand {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;

        TreeMap<Integer,Integer>map=new TreeMap<>();
        for(int el : hand){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        while(!map.isEmpty()){
            int firstEl=map.firstKey();
            for(int i=0;i<groupSize;i++){
                if(!map.containsKey(firstEl+i)) return false;
                int freq=map.get(firstEl+i);
                freq--;
                if(freq==0) map.remove(firstEl+i);
                else map.put(firstEl+i,freq);
            }
        }
        return true;
    }
}
