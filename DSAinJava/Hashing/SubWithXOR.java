package Hashing;
import java.util.*;
public class SubWithXOR {
    public int solve(int[] A, int B) {
        int n=A.length;
        int count=0;
        int XOR =0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            XOR^=A[i];
            //Y^B=XOR=>Y=B^XOR , Y gives the no. of subarrays

            if(map.get(XOR^B)!=null){
                count+=map.get(XOR^B);
            }
            if(XOR==B){
                count++;
            }
            if(map.get(XOR)!=null){
                map.put(XOR,map.get(XOR)+1);//incresing freq
            }
            else{
                map.put(XOR,1);
            }
        }
        return count;
    }
}
