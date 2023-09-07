package DSAinJava.Hashing;
import java.util.*;
public class SquareStreak {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        Map<Double,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            double sqrt=Math.sqrt(arr[i]);
            if(map.containsKey(sqrt)){
                map.put((double)arr[i],map.get(sqrt)+1);
            }
            else{
                map.put((double)arr[i],1);
            }
        }
        int max=0;
        for(Map.Entry<Double,Integer>entry:map.entrySet()){
            max=Math.max(max,entry.getValue());
        }
        if(max>2) System.out.println(max);
        else System.out.println(-1);
    }
}
