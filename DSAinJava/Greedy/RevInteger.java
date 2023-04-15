package DSAinJava.Greedy;

public class RevInteger {
    public int reverse(int x) {
        int rev=0;
        while(x!=0){
            int lastDigit=x%10;
            x/=10;
            //overflow and underflow cases
            if(rev>Integer.MAX_VALUE/10){
                return 0;
            }
            if(rev<Integer.MIN_VALUE/10){
                return 0;
            }
            rev=rev*10+lastDigit;
        }
        return rev;
    }
}
