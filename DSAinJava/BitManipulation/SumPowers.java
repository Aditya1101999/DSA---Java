package DSAinJava.BitManipulation;

public class SumPowers {
    public static long sumOfPowers(long a, long b) {
        long sum=0;
        for(long i=a;i<=b;i++){
            sum+=powerSum(i);
        }
        return sum;
    }
    private static long powerSum(long num){
        long count=0;
        long temp=num;
        for(long i=2;i*i<=temp;i++){//i<=sqrt(num) or i^2<=num
            while(num%i==0){
                num/=i;
                count++;
            }
        }
        if(num!=1){//num is prime having no other factors
            count++;
        }
        return count;
    }
}
