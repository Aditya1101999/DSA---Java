package DSAinJava.DynProg;
import java.util.*;
public class StringCompression {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n=s.length();
        int[][][][] dp=new int[n+1][27][n+1][k+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<27;j++){
                for(int l=0;l<n+1;l++){
                    Arrays.fill(dp[i][j][l],-1);
                }
            }
        }
        return compressionHelper(s,0,26,0,k,dp);//26 represents empty char , prevchar frequency
    }
    private int compressionHelper(String s,int i,int prevChar,int freq,int k,int[][][][] dp){
        if(i==s.length()) return 0;
        if( dp[i][prevChar][freq][k]!=-1) return  dp[i][prevChar][freq][k];
        int delete=Integer.MAX_VALUE;
        if(k>0) delete=compressionHelper(s,i+1,prevChar,freq,k-1,dp);
        int keep;
        if(s.charAt(i)-'a'==prevChar){
            //RLE
            int oneLengthAdd=0;
            if(freq==1||freq==9||freq==99){
                oneLengthAdd=1;
            }
            keep=oneLengthAdd+compressionHelper(s,i+1,s.charAt(i)-'a',freq+1,k,dp);
        }
        else{//current char frequency
            keep=1+compressionHelper(s,i+1,s.charAt(i)-'a',1,k,dp);
        }
        return dp[i][prevChar][freq][k]=Math.min(delete,keep);
    }
}
