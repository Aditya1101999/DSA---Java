package advancedPatterns;

public class solidrhom {
    public static void solid_rhombus(int Rows) {
        //outer loop=rows
        for (int i = 1; i <= Rows; i++) {
            //spaces
            for (int j = 1; j <= Rows - i; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 1; j <= Rows; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static void main(String args[]){
        solid_rhombus(5);
    }
}
