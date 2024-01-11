package DSAinJava.DivideAndConq;

public class minimizeSet {
    public int minimizeSetDivisors(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long low = 1;
        long high = Integer.MAX_VALUE;
        long ans = high;
        long lcm = lcm(divisor1, divisor2);
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long common = mid / lcm;
            long count1 = mid / divisor1 - common;
            long count2 = mid / divisor2 - common;
            long uncommon = mid - (count1 + count2 + common);
            long cnt1 = uniqueCnt1;
            long cnt2 = uniqueCnt2;
            cnt1 -= Math.min(cnt1, count2);
            cnt2 -= Math.min(cnt2, count1);
            if (cnt1 + cnt2 <= uncommon) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
