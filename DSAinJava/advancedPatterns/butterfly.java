package advancedPatterns;

public class butterfly {
    public static void butterfly_pattern(int n) {
        //first half
        for (int i = 1; i <= n; i++) {
            //i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //2*n-i spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            //i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //second half
        for (int i = n; i >= 1; i--) {
            //i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //2*n-i spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            //i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        }
    public static void main (String args[]){
            butterfly_pattern(4);
        }
    }


