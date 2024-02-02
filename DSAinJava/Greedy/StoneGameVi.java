package DSAinJava.Greedy;
import java.util.Arrays;
public class StoneGameVi {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n=aliceValues.length;
        int[][] values=new int[n][3];
        for(int i=0;i<n;i++){
            values[i]=new int[]{aliceValues[i],bobValues[i],aliceValues[i]+bobValues[i]};
        }
        Arrays.sort(values,(a,b)->b[2]-a[2]);
        int alice=0;
        for(int i=0;i<n;i++){
            if(i%2==0){//alice
                alice+=values[i][0];
            }
            else{
                alice-=values[i][1];
            }
        }
        if(alice==0) return 0;
        return (alice>0) ? 1 : -1;
    }
}
