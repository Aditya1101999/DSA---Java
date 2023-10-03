package DSAinJava.Hashing;
import java.util.*;
public class subsetOfOtherArray {
    //approach 1->sorting and merging (nlog n + m log m )
    //approach 2-> frequency table(m+n)-> if search not constant then m log(m+n)
    public String isSubset( long a1[], long a2[], long n, long m) {
        Map<Long , Integer>map=new HashMap<>();
        for(long el : a1){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        for(int i=0;i<m;i++){
            if(!map.containsKey(a2[i]) || map.get(a2[i])==0){
                return "No";
            }
            else map.put(a2[i],map.getOrDefault(a2[i],0)-1);
        }
        return "Yes";
    }
}
