package DSAinJava.DynProg;
import java.util.*;
public class MusicPlaylists {
    public int numMusicPlaylists(int n, int goal, int k) {
        int mod=(int)1e9+7;
        int[][] dp=new int[goal+1][n+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return count(n,goal,k,0,dp);
    }
    private int count(int n,int goal,int k,int oldSongs,int[][] dp){
        int mod=(int)1e9+7;
        if(goal==0 && oldSongs==n){//all songs played
            return 1;
        }
        if(goal==0||oldSongs>n){//no more songs can be listened
            return 0;
        }
        if(dp[goal][oldSongs]!=-1){
            return dp[goal][oldSongs];
        }
        //new song->new Songs*possibilites
        long res=(long)(n-oldSongs)*count(n,goal-1,k,oldSongs+1,dp)%mod;
        //old song
        if(oldSongs>k){//at least k songs should be played to allow repeatation
            res+=(long)(oldSongs-k)*count(n,goal-1,k,oldSongs,dp)%mod;//valid songs allowed are k other songs (gap)
        }
        return dp[goal][oldSongs]=(int)res%mod;
    }
}
