package DSAinJava.Heaps;
import java.util.*;
public class SortCharacters {
    public String frequencySort(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int max=0;
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
            max=Math.max(max,map.get(c));
        }
        List<Character>[] bucket=new List[max+1];
        for(Map.Entry<Character,Integer>entry : map.entrySet()){
            int index=entry.getValue();
            if(bucket[index]==null){
                bucket[index]=new ArrayList<>();
            }
            bucket[index].add(entry.getKey());
        }
        StringBuilder ans=new StringBuilder();
        for(int i=max;i>0;i--){
            List<Character>curr=bucket[i];
            if(curr!=null){
                for(char c : curr){
                    for(int j=0;j<i;j++){
                        ans.append(c);
                    }
                }
            }
        }
        return ans.toString();
    }
}
