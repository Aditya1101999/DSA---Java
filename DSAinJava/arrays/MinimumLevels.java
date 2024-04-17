package DSAinJava.arrays;

public class MinimumLevels {
    public int minimumLevels(int[] possible) {
        int total=0;
        for(int el : possible){
            if(el==1) total++;
            else total--;
        }
        int daniel=0;
        int bob=0;
        int n=possible.length;
        for(int i=0;i<n-1;i++){//max levels daniel can play
            if(possible[i]==1) daniel++;
            else daniel--;

            bob=total-daniel;
            if(daniel>bob) return i+1;
        }
        return -1;
    }
}
