package DSAinJava.Queues;
import java.util.*;
public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        Queue<Integer>q=new LinkedList<>();
        int time=0;
        for(int i=0;i<n;i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int index=q.remove();
            arr[index]--;
            time++;
            if(arr[index]!=0) q.add(index);
            if(index==k && arr[index]==0){
                break;
            }
        }
        System.out.println(time);
    }
}
