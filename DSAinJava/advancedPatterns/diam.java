package advancedPatterns;

public class diam {
    public static void diamond_pattern(int n) {
        //first half
        for (int i = 1; i <= n; i++) {
            //spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            // stars=(2*i)-1
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //second half
        for (int i = n; i >= 1; i--) {
            //spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    public static void main (String args[]){
        diamond_pattern(4);
    }
}

