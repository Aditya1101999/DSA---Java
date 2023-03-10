package advancedPatterns;

public class zeroonetri {
    public static void zeroone_triangle(int n) {
        //outer loop=rows
        for (int i = 1; i <= n; i++) {
            //inner loop
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        zeroone_triangle(4);
    }
}
