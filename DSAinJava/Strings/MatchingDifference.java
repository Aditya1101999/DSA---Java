package DSAinJava.Strings;

public class MatchingDifference {
    public static int minimum_difference(int n, String[] words) {
        int len=words[0].length();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int curr=0;
                for(int k=0;k<len;k++){
                    curr+=Math.abs(words[i].charAt(k)-words[j].charAt(k));
                }
                ans=Math.min(ans,curr);
            }
        }
        return ans;
    }
}
