package DSAinJava.BitManipulation;
import java.util.*;
public class countTripletsXOR {
    public int countTriplets(int[] arr) {
        int n=arr.length;
        int prefixXor=0;
        int ans=0;
        Map<Integer,Integer>count=new HashMap<>();//prefixSum , frequency
        Map<Integer,Integer>indices=new HashMap<>();//prefixSum , sum of indices having that
        count.put(0,1);
        indices.put(0,-1);
        for(int k=0;k<n;k++){
            prefixXor^=arr[k];
            /*
            individual contribution for any xor pair : k-i-1
            for i1,i2 ,.... , total contribution : (k-i1-1) + (k-i2-1) + .... = prefixCount*k -(i1+i2+...)-1*prefixCount
            */
            int occurances=count.getOrDefault(prefixXor,0);
            ans+=occurances*k-indices.getOrDefault(prefixXor,0)-occurances;
            count.put(prefixXor,count.getOrDefault(prefixXor,0)+1);
            indices.put(prefixXor,indices.getOrDefault(prefixXor,0)+k);
        }
        return ans;
    }
}
