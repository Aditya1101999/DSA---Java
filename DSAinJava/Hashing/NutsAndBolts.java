package DSAinJava.Hashing;
import java.util.*;
public class NutsAndBolts {
    void matchPairs(int n, char nuts[], char bolts[]) {
        Set<Character>set = new HashSet<>();
        List<Character>list=Arrays.asList('!', '#', '$', '%', '&', '*', '?', '@', '^');
        for(char symbol : nuts){
            set.add(symbol);
        }
        int index=0;
        for(char el : list){
            if(set.contains(el)){
                nuts[index]=bolts[index]=el;
                index++;
            }
        }


    }
}
