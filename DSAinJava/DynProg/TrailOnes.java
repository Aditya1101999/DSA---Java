package DSAinJava.DynProg;

public class TrailOnes {
    static int numberOfConsecutiveOnes(int n) {
        int mod=(int)1e9+7;
        return ((int)Math.pow(2,n)-countNonConsecutiveStrings(n))%mod;
    }
    static int countNonConsecutiveStrings(int n) {
        int mod=(int)1e9+7;
        // int[] dp0=new int[n+1];//all strings ending at 0
        // int[] dp1=new int[n+1];//all strings ending at 1
        // dp0[1]=1;
        // dp1[1]=1;
        int countZeros=1;
        int countOnes=1;
        for(int i=2;i<n+1;i++){
            // dp0[i]=(dp0[i-1]+dp1[i-1])%mod;
            // dp1[i]=dp0[i-1];
            int newZeroCount=(countZeros+countOnes)%mod;
            int newOneCount=countZeros;

            countZeros=newZeroCount;
            countOnes=newOneCount;
        }
        // return (dp0[n]+dp1[n])%mod;
        return (countZeros+countOnes)%mod;
    }
}
