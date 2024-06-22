package DSAinJava.arrays;
import java.util.*;
public class PrimePairTarget {
    private static boolean[] sieve(int n){
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        return isPrime;
    }
    public static ArrayList<Integer> getPrimes(int n) {
        boolean[] isPrime=sieve(n);
        for(int i=2;i<n;i++){
            if(isPrime[i] && isPrime[n-i]){
                return new ArrayList<>(Arrays.asList(i,n-i));
            }
        }
        return new ArrayList<>(Arrays.asList(-1,-1));
    }
}
