package DSAinJava.arrays;
import java.util.Scanner;
public class QueueChallenge {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();


        int positions = Math.min(N-x,y+1);

        System.out.println(positions);
    }
}
