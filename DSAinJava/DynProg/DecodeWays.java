package DSAinJava.DynProg;
public class DecodeWays {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;//string with leading zeros are invalid
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;//considering it as a valid no. at 1st index->just to get dp[2]
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for(int i=2;i<=n;i++){
            int tens=s.charAt(i-2)-'0';//prev char
            int ones=s.charAt(i-1)-'0';//curr char
            int no=getNo(tens,ones);
            if(no>=10 && no<=26){//group last 2 digits
                dp[i]+=dp[i-2];
            }
            if(ones!=0){//last character can be included
                dp[i]+=dp[i-1];
            }

        }
        return dp[n];
    }
    private int getNo(int tens,int ones){
        return tens*10+ones;
    }
}
