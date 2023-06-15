package DSAinJava.Hashing;
import java.util.*;
public class EqRowColPairs {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int ans=0;
        //<Hash,Frequency>
        Map<String,Integer>rowHash=new HashMap<>();
        Map<String,Integer>colHash=new HashMap<>();
        for(int i=0;i<n;i++){//storing rowHash
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(grid[i][j]).append("#");
            }
            rowHash.put(sb.toString(),rowHash.getOrDefault(sb.toString(),0)+1);
        }
        for(int j=0;j<n;j++){//storing colHash
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(grid[i][j]).append("#");
            }
            colHash.put(sb.toString(),colHash.getOrDefault(sb.toString(),0)+1);
        }
        for(Map.Entry<String,Integer>entry:rowHash.entrySet()){
            String rHash=entry.getKey();
            if(colHash.containsKey(rHash)){
                ans+=rowHash.get(rHash)*colHash.get(rHash);
            }
        }
        return ans;
    }
}
