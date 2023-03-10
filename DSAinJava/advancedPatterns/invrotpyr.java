package advancedPatterns;

public class invrotpyr {
    public static void inverted_rotated_pyra(int Rows) {
        //outer loop=rows
        for (int i = 1; i <= Rows; i++) {
            //spaces
            for (int j = 1; j <= Rows - i; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

            }
        }
        public static void main(String args[]){
        inverted_rotated_pyra(7);
        }
}
