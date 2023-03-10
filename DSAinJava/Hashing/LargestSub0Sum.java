package Hashing;
import java.util.*;
public class LargestSub0Sum {
    public static int maxLen(int[] arr, int n) {
        Map<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                max=i+1;//ans
            }
            else{
                if(map.get(sum)!=null){
                    max=Math.max(max,i-map.get(sum));//last index of sum
                }
                else{
                    map.put(sum,i);
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] A = {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(A,A.length));
    }

}
