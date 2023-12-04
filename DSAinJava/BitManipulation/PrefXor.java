package DSAinJava.BitManipulation;

public class PrefXor {
    public int[] findArray(int[] pref) {
        int n=pref.length;
        int[] ans=new int[n];
        ans[0]=pref[0];
        for(int i=1;i<n;i++){
            ans[i]=pref[i]^pref[i-1];
        }
        return ans;
    }
    public int[] findArraySpaceOptimized(int[] pref) {
        int n=pref.length;
        for(int i=n-1;i>=1;i--){
            pref[i]^=pref[i-1];
        }
        return pref;
    }
}
