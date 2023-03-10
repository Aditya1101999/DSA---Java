package DynProg;

public class SieveEratosthenes {
    public static void primeNumbersInrange(int n){
        boolean[] isPrime=new boolean[n+1];
        for(int i=0;i<n+1;i++){
            isPrime[i]=true;
        }
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j=j+i){
                    isPrime[j]=false;
                }
            }
        }
        for(int i=0;i<n+1;i++){
            if(isPrime[i]) System.out.print(i+" ");
        }
    }
    public static void main(String[] args){
        int n=50;
        primeNumbersInrange(n);
    }
}
