package advancedPatterns;

public class hollowrhom {
    public static void hollow_rhombus(int Rows) {
        //outer loop=rows
        for (int i = 1; i <= Rows; i++) {
            //spaces
            for (int j = 1; j <= Rows - i; j++) {
                System.out.print(" ");
            }
            //hollow rectangele-stars
            for (int j = 1; j <= Rows; j++) {
                if(i==1||i==Rows||j==1||j==Rows){
                    System.out.print("*");

                }
                else{
                    System.out.print(" ");
                }

            }
            System.out.println();


        }
    }
    public static void main(String args[]){
        hollow_rhombus(5);
    }
}
