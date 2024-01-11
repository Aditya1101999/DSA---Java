package DSAinJava.Graphs;
import java.util.Arrays;
public class ConvertString {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] matrix=new long[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
            matrix[i][i]=0;
        }
        for(int i=0;i<original.length;i++){
            int val1=original[i]-'a';
            int val2=changed[i]-'a';
            matrix[val1][val2]=Math.min(matrix[val1][val2], cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        long ans=0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)){
                int val1=source.charAt(i)-'a';
                int val2=target.charAt(i)-'a';
                long curr=matrix[val1][val2];
                if(curr==Integer.MAX_VALUE) return -1L;
                ans+=curr;
            }
        }
        return ans;
    }
}
