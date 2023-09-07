package DSAinJava.Strings;

public class myAtoi {
    public int myAtoi(String s) {
        int n = s.length();
        boolean neg = false;
        boolean signEncountered = false;
        int ans = 0;
        int i = 0; // iterator
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        while (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (signEncountered) {
                return 0;
            }
            signEncountered = true;
            if (s.charAt(i) == '-') {
                neg = true;
            }
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            int curr = s.charAt(i) - '0';
            if (ans > (Integer.MAX_VALUE - curr) / 10) {//overflow
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + curr;
            i++;
        }
        while (i < n) {
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') {
                return 0; // Invalid input
            }
            i++;
        }
        return neg ? -ans : ans;
    }
}
