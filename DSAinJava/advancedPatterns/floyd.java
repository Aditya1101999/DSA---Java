package advancedPatterns;

public class floyd {
    public static void floyd_triangle(int n) {
        int counter = 1;

        //outer loop=rows
        for (int i = 1; i <= n; i++) {
            //inner loop=how many times counter printed
            for (int j = 1; j <= i; j++) {
                System.out.print(counter);
                counter++;
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        floyd_triangle(5);
    }

}
