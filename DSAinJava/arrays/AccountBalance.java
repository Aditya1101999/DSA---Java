package DSAinJava.arrays;

public class AccountBalance {
    public int accountBalanceAfterPurchase(int number) {
        double quotient = (double) number / 10.0;
        long roundedQuotient = Math.round(quotient);
        int ans= (int) (roundedQuotient * 10);
        return 100-ans;
    }
}
