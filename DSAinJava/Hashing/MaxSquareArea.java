package DSAinJava.Hashing;
import java.util.*;
public class MaxSquareArea {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int mod=(int)1e9+7;
        Set<Integer>fences=new HashSet<>();
        List<Integer>heights=new ArrayList<>();
        heights.add(1);
        heights.add(m);
        for(int el : hFences) heights.add(el);
        List<Integer>widths=new ArrayList<>();
        widths.add(1);
        widths.add(n);
        for(int el : vFences) widths.add(el);

        for(int i=0;i<heights.size();i++){
            for(int j=i+1;j<heights.size();j++){
                fences.add(Math.abs(heights.get(j)-heights.get(i)));
            }
        }
        long max=0;
        for(int i=0;i<widths.size();i++){
            for(int j=i+1;j<widths.size();j++){
                int curr=Math.abs(widths.get(j)-widths.get(i));
                if(fences.contains(curr)){
                    max=Math.max(max,curr);
                }
            }
        }
        int result = (int) (max * max % mod);
        return result == 0 ? -1 : result;
    }
}
