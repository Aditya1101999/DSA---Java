package advancedPatterns;

public class invhafpyr {
    public static void inv_half_pyr(int n) {
        //outer loop=rows
        for (int i = 1; i <= n; i++) {
            //inner loop=columns
            for (int j = 1; j <= (n-i+1); j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        inv_half_pyr(5);
    }

}
