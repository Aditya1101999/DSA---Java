package DSAinJava.Hashing;
import java.util.*;
public class findWinners {
    public List<List<Integer>> getWinners(int[][] matches) {
        int max=0;
        for(int[] match : matches){
            max=Math.max(max,Math.max(match[0],match[1]));
        }
        int[] map=new int[max+1];
        Arrays.fill(map,-1);
        for(int[] match : matches){
            int winner=match[0];
            int loser=match[1];
            if(map[winner]==-1){
                map[winner]=0;
            }
            if(map[loser]==-1){
                map[loser]=1;
            }
            else{
                map[loser]++;
            }
        }
        List<Integer>winnerList=new ArrayList<>();
        List<Integer>loserList=new ArrayList<>();
        for(int i=0;i<max+1;i++){
            if(map[i]==0){
                winnerList.add(i);
            }
            else if(map[i]==1){
                loserList.add(i);
            }
        }
        List<List<Integer>>ans=new ArrayList<>();
        ans.add(new ArrayList<>(winnerList));
        ans.add(new ArrayList<>(loserList));
        return ans;
    }
}
