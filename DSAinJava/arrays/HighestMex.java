package DSAinJava.arrays;
import java.util.*;
public class HighestMex {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Size of the multi-set
            int K = scanner.nextInt();
            int[] arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=scanner.nextInt();
            }
            Arrays.sort(arr);
            int i=0;
            int mex=0;
            while(i<N){
                if(arr[i]==mex){
                    i++;
                    mex++;
                }
                else if(K>0){
                    mex++;
                    K--;
                }
                else{
                    break;
                }
            }
            if(K>0) mex+=K;
            System.out.println(mex);
        }
    }
}
