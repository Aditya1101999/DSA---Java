package DSAinJava.Heaps;
import java.util.*;
public class TopKWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer>map=new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //we need those entries out , whose frequencies are less
        //if frequencies are equal , pick out the lexicographically larger , as lower lexicography is given preference
        PriorityQueue<Map.Entry<String,Integer>>pq=new PriorityQueue<>((a,b)->{
            if(Objects.equals(a.getValue(), b.getValue())){
                return b.getKey().compareTo(a.getKey());
            }
            return a.getValue()-b.getValue();
        });
        for(Map.Entry<String,Integer>entry : map.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String>ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(0,pq.poll().getKey());
        }
        return ans;
    }
}
