package DSAinJava.Hashing;
import java.util.*;
public class CountingProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Map<Integer,Integer>map=new HashMap<>();
        long ans=0;
        for(int i=0;i<n;i++){
            int diff=arr[i]-i;
            ans+=map.getOrDefault(diff,0);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        System.out.println(ans);
    }
}
