package DSAinJava.Hashing;
import java.util.*;
public class Groups {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=groupSizes.length;
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int currGroup=groupSizes[i];
            if(!map.containsKey(currGroup)){
                map.put(groupSizes[i],new ArrayList<>());
            }
            List<Integer>group=map.get(currGroup);
            group.add(i);
            map.put(currGroup,group);
            if(group.size()==currGroup){
                ans.add(group);
                map.remove(currGroup);
            }
        }
        return ans;
    }
}
