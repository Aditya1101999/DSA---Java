package Hashing;
import java.util.*;
public class DistinctWindow {
    public static int findSubString( String str) {
        int n=str.length();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        int distinct=map.size();
        map=new HashMap<>();
        int start=0;
        int startIndex=-1;//only for substr
        int minLength=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            if(map.size()==distinct){
                while(map.get(str.charAt(start))>1){
                    map.put(str.charAt(start),map.getOrDefault(str.charAt(start),0)-1);
                    start++;
                }
                int currLength = i - start + 1;
                if(currLength<minLength) startIndex=start;//only for substr
                minLength=Math.min(minLength,currLength);
            }
        }
        System.out.println(str.substring(startIndex,startIndex+minLength));
        return minLength;
    }

    public static void main(String[] args) {
        String str="AABBBCBBAC";
        System.out.println(findSubString(str));
    }
}
