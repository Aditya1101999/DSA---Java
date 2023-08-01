package DSAinJava.arrays;

public class CircularGame {
    public int findTheWinner(int n, int k) {
       // return Helper(n,k)+1;
        return HelperIterative(n,k)+1;//adjust indexing
    }
    private int Helper(int n,int k){
        if(n==1){
            return 0;
        }
        return (Helper(n-1,k)+k)%n;//to limit answer in bounds (1 to n)
    }
    private int HelperIterative(int n,int k){
        int ans=0;
        for(int i=1;i<=n;i++){
            ans=(ans+k)%i;
        }
        return ans;
    }
}
