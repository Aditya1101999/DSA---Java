package DSAinJava.Two_DArrays;
import java.util.*;
public class MagicalPark {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int S = scanner.nextInt();
        boolean flag=true;
        char[][] matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(S<K){
                    flag=false;
                    break;
                }
                if(matrix[i][j]=='.'){
                    S-=2;
                }
                else if(matrix[i][j]=='*'){
                    S+=5;
                }
                else{
                    break;
                }
                if(j!=M-1) S--;
            }
            if(!flag) break;
        }
        if(S<K || !flag) System.out.println("No");
        else{
            System.out.println("Yes");
            System.out.println(S);
        }
    }
}

