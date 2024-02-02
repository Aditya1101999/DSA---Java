package DSAinJava.Greedy;

public class MinNonZerOProd {
    /*
    p = 3
    nums = [001, 010, 011, 100, 101, 110, 111]
    2^p-1=7
    if we notice correctly
    from 0 to 2^p-1 , each number is a compliment of one another
    000-111
    001-110
    010-101
    011-100
    ...
    nd we can perform to achive the 2nd pair from all the pairs except the maximum no.
    i.e. 001-110(i.e. 1 and its corresponding compliment) i.e. ..00001 and ..11110
    because we need minimum "non-zero"
    now , how many pairs ?
    total elements(max)=2^p-1
    elements applicable for pairing : max-1
    so total pairs=(max-1)/2
    i.e. (1*max-1) *(1*max-1)*......(max-1)/2 times

    ans=> pairs product * max element(which was excluded earlier)

   */
    public int minNonZeroProduct(int p) {
        int mod=(int)1e9+7;
        long max=(long)Math.pow(2,p)-1;
        long pairs=(max-1)/2;
        long pairProduct=pow(max-1,pairs);
        long product=((pairProduct%mod)*(max%mod))%mod;
        return (int)product;
    }
    private long pow(long num,long power){
        if(power==0){
            return 1L;
        }
        int mod=(int)1e9+7;
        long temp=pow(num,power/2);
        temp%=mod;
        if(power%2==0){
            return (temp*temp)%mod;
        }
        return (((temp*temp)%mod)*(num%mod))%mod;
    }
}
