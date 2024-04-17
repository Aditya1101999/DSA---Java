package DSAinJava.Hashing;
import java.util.*;
public class uniqInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        int n=arr.length;
        for(int el : arr){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        int[] freq=new int[n+1];
        for(int value : map.values()){
            freq[value]++;
        }
        int uniqueElements=map.size();
        for(int i=1;i<=n;i++){
            int removingEle=Math.min(freq[i],k/i);
            uniqueElements-=removingEle;
            int elementsRemoved=removingEle*i;
            k-=elementsRemoved;
            if(k<=i) return uniqueElements;

        }
        return 0;
    }
}
