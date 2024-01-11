package DSAinJava.DynProg;

public class PeopleSharingSecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp=new long[n+1];//stores no of people who found secret at a particular day
        long mod = (long)1e9 + 7;
        long peopleSharingSecret=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            long peopleForgot=dp[Math.max(0,i-forget)];
            long newPeopleSharing=dp[Math.max(0,i-delay)];

            peopleSharingSecret+=(newPeopleSharing-peopleForgot+mod)%mod;
            dp[i]=peopleSharingSecret;//x people sharing secret at day i=> with x new people
        }
        long ans=0;
        for (int i = n - forget + 1; i <= n; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
    }
}
